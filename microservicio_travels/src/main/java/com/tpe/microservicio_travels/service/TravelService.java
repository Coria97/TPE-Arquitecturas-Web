package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.dto.ScooterStatsUpdateDTO;
import com.tpe.microservicio_travels.dto.TravelsYearDTO;
import com.tpe.microservicio_travels.entity.Billing;
import com.tpe.microservicio_travels.entity.BillingMethod;
import com.tpe.microservicio_travels.entity.TravelStop;
import com.tpe.microservicio_travels.feign.ScooterFeignClient;
import com.tpe.microservicio_travels.repository.BillingMethodRepository;
import com.tpe.microservicio_travels.repository.BillingRepository;
import com.tpe.microservicio_travels.repository.TravelRepository;
import com.tpe.microservicio_travels.repository.TravelStopRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tpe.microservicio_travels.entity.Travel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Timestamp;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private TravelStopRepository travelStopRepository;
    @Autowired
    private ScooterFeignClient scooterFeignClient;
    @Autowired
    private BillingMethodRepository billingMethodRepository;
    @Autowired
    private BillingRepository billingRepository;

    public List<TravelsYearDTO> getScootersByMinTravels(Long userId, int year, int minTravels){
        return travelRepository.getScootersByMinTravels(year, minTravels);
    }

    public Travel finishTravel(Long travelId) {
        // Actualizo el viaje.
        Date currentDate = new Date();
        String state = "Finished";
        float randomDistance = 1 + (float) Math.random() * 29;
        Optional<Travel> travel = travelRepository.findById(travelId);
        if (travel.isPresent())
            travelRepository.finishTravel(travelId, currentDate, state, randomDistance);

        // Obtengo info sobre el viaje.
        float totalMinutes = 0;
        String billingType = "normal";
        List<TravelStop> travelStops = travelStopRepository.findByTravelId(travelId);
        for (TravelStop stop : travelStops) {
            if (stop.getStart() != null && stop.getEnd() != null) {
                long diffInMillis = stop.getEnd().getTime() - stop.getStart().getTime();
                float diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
                if (diffInMinutes > 15)
                    billingType = "extra";
                totalMinutes += diffInMinutes;
            }
        }

        // Actualizo el travel con la nueva info cargada.
        Optional<Travel> completedTravel = travelRepository.findById(travelId);

        // Creo la factura
        BillingMethod billingMethod = billingMethodRepository.findActiveBillingMethod(currentDate, billingType);
        float total = completedTravel.get().getDistance() * billingMethod.getPrice();

        Billing bill = new Billing();
        bill.setBillingMethod(billingMethod);
        bill.setState("Impaga");
        bill.setAmount(total);
        bill.setTravel(completedTravel.get());
        bill.setAmountDebt(total);
        bill.setBillingDate(currentDate);
        billingRepository.save(bill);

        // Actualizo info al scooter
        ScooterStatsUpdateDTO scooterStatsUpdate = new ScooterStatsUpdateDTO(randomDistance, totalMinutes, completedTravel.get().getStopDestinyId());
        scooterFeignClient.updateStatsScooter((long) completedTravel.get().getScooterId(), scooterStatsUpdate);

        return completedTravel.get();
    }

    public TravelStop startTravelStops(Long travelId){
        Travel travel = travelRepository.findById(travelId)
                .orElseThrow(() -> new EntityNotFoundException("Travel not found"));

        TravelStop travelStop = new TravelStop();
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        travelStop.setStart(currentTimestamp);
        travelStop.setTravel(travel);
        return travelStopRepository.save(travelStop);
    }

    public TravelStop endTravelStops(Long travelId, Long stopsId) {
        Travel travel = travelRepository.findById(travelId)
                .orElseThrow(() -> new EntityNotFoundException("Travel not found"));

        TravelStop travelStop = travelStopRepository.findByIdAndTravel(stopsId, travel)
                .orElseThrow(() -> new EntityNotFoundException("TravelStop not found"));


        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        travelStop.setEnd(currentTimestamp);
        return travelStopRepository.save(travelStop);
    }

    public List<Travel> findAll() {
        return travelRepository.findAll();
    }

    public Optional<Travel> findById(Long id) {
        return travelRepository.findById(id);
    }

    public Travel save(Travel travel) {
        return travelRepository.save(travel);
    }

    public void deleteById(Long id) {
        travelRepository.deleteById(id);
    }

}
