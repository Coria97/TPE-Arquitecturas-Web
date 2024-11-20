package com.tpe.microservicio_stops.service;

import com.tpe.microservicio_stops.dto.ScooterStatesDTO;
import com.tpe.microservicio_stops.dto.ScooterStatsUpdateDTO;
import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.entity.Scooter;
import com.tpe.microservicio_stops.entity.Stop;
import com.tpe.microservicio_stops.repository.ScooterRepository;
import com.tpe.microservicio_stops.repository.StopRepository;
import com.tpe.microservicio_stops.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScooterService {

    @Autowired
    private ScooterRepository scooterRepository;
    @Autowired
    private UserUtil userUtil;
    @Autowired
    private StopRepository stopRepository;

    public List<ScooterUsageDTO> getScootersUsage() {
        return scooterRepository.getScootersUsage();
    }

    public List<ScooterStatesDTO> getScooterStates(Long userId) {
        if (!userUtil.isAdmin(userId))
            return null;
        return scooterRepository.getScooterStates();
    }

    public Scooter createScooter(Scooter scooter) {
        return scooterRepository.save(scooter);
    }

    public void deleteScooter(Long id) {
        scooterRepository.deleteById(id);
    }

    public Scooter updateScooter(Long id, Scooter scooter) {
        Optional<Scooter> existingScooter = scooterRepository.findById(id);
        if (existingScooter.isPresent()) {
            Scooter updatedScooter = existingScooter.get();
            updatedScooter.setCode(scooter.getCode());
            updatedScooter.setKm(scooter.getKm());
            updatedScooter.setTimeUsage(scooter.getTimeUsage());
            updatedScooter.setState(scooter.getState());
            updatedScooter.setStop(scooter.getStop());
            return scooterRepository.save(updatedScooter);
        }
        return null;
    }

    public Scooter updateStatsScooter(Long id, ScooterStatsUpdateDTO scooterStatsUpdateDTO) {
        Scooter scooter = scooterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scooter not found"));

        float km = scooter.getKm() + scooterStatsUpdateDTO.getKm();
        float timeUsage = scooter.getTimeUsage() + scooterStatsUpdateDTO.getTimeUsage();
        long stopId = scooterStatsUpdateDTO.getStopId();
        Optional<Stop> newStop = stopRepository.findById(stopId);

        scooter.setKm(km);
        scooter.setTimeUsage(timeUsage);
        scooter.setStop(newStop.get());
        scooter.setState("Available");

        return scooterRepository.save(scooter);
    }

    public Scooter getScooterById(Long id) {
        return scooterRepository.findById(id).orElse(null);
    }

    public List<Scooter> getAllScooters() {
        return scooterRepository.findAll();
    }


}