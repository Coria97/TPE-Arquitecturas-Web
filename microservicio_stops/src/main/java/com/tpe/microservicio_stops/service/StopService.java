package com.tpe.microservicio_stops.service;

import com.tpe.microservicio_stops.entity.Stop;
import com.tpe.microservicio_stops.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopService {
    @Autowired
    private StopRepository stopRepository;

    // Alta
    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }

    // Baja
    public void deleteStop(Long id) {
        stopRepository.deleteById(id);
    }

    // Modificación
    public Stop updateStop(Long id, Stop stop) {
        Optional<Stop> existingStop = stopRepository.findById(id);
        if (existingStop.isPresent()) {
            Stop updatedStop = existingStop.get();
            updatedStop.setLocation(stop.getLocation());
            updatedStop.setSlots(stop.getSlots());
            updatedStop.setFull(stop.isFull());
            updatedStop.setScooterList(stop.getScooterList());
            return stopRepository.save(updatedStop);
        }
        return null; // o lanzar una excepción
    }

    // Obtener por ID
    public Stop getStopById(Long id) {
        return stopRepository.findById(id).orElse(null);
    }

    // Obtener todos
    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }
}
