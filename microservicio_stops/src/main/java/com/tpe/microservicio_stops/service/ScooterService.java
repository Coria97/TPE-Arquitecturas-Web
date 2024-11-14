package com.tpe.microservicio_stops.service;

import com.tpe.microservicio_stops.dto.ScooterStatesDTO;
import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.entity.Scooter;
import com.tpe.microservicio_stops.repository.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScooterService {

    @Autowired
    private ScooterRepository scooterRepository;

    public List<ScooterUsageDTO> getScootersUsage() {
        return scooterRepository.getScootersUsage();
    }

    public List<ScooterStatesDTO> getScooterStates(){
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
            updatedScooter.setTimeOut(scooter.getTimeOut());
            updatedScooter.setState(scooter.getState());
            updatedScooter.setStop(scooter.getStop());
            return scooterRepository.save(updatedScooter);
        }
        return null;
    }


    public Scooter getScooterById(Long id) {
        return scooterRepository.findById(id).orElse(null);
    }

    public List<Scooter> getAllScooters() {
        return scooterRepository.findAll();
    }


}