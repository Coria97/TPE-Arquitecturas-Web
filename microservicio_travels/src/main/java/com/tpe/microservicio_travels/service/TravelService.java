package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.dto.ScooterStatsUpdateDTO;
import com.tpe.microservicio_travels.dto.TravelsYearDTO;
import com.tpe.microservicio_travels.entity.TravelStop;
import com.tpe.microservicio_travels.feign.ScooterFeignClient;
import com.tpe.microservicio_travels.repository.TravelRepository;
import com.tpe.microservicio_travels.repository.TravelStopRepository;
import com.tpe.microservicio_travels.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpe.microservicio_travels.entity.Travel;
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
    private UserUtil userUtil;
    @Autowired
    private ScooterFeignClient scooterFeignClient;

    public List<TravelsYearDTO> getScootersByMinTravels(Long userId, int year, int minTravels){
        if (!userUtil.isAdmin(userId))
            return null;
        return travelRepository.getScootersByMinTravels(year, minTravels);
    }

    public Optional<Travel> finishTravel(Long travelId) {
        Date currentDate = new Date();
        String state = "finished";
        Optional<Travel> travel = travelRepository.findById(travelId);

        if (travel.isPresent()) {
            travelRepository.finishTravel(travelId, currentDate, state);

            List<TravelStop> travelStops = travelStopRepository.findByTravelId(travelId);
            float totalMinutes = 0;
            for (TravelStop stop : travelStops) {
                if (stop.getStart() != null && stop.getEnd() != null) {
                    long diffInMillis = stop.getEnd().getTime() - stop.getStart().getTime();
                    float diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(diffInMillis);
                    totalMinutes += diffInMinutes;
                }
            }

            Travel completedTravel = travel.get();
            ScooterStatsUpdateDTO scooterStatsUpdate = new ScooterStatsUpdateDTO(completedTravel.getDistance(), totalMinutes);

            scooterFeignClient.updateStatsScooter((long) completedTravel.getScooterId(), scooterStatsUpdate);
        }
        return travel;
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
