package com.tpe.microservicio_stops.service;

import com.tpe.microservicio_stops.entity.Stop;
import com.tpe.microservicio_stops.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StopService {
    @Autowired
    private StopRepository stopRepository;

    public List<Stop> getCloseScooters(float x, float y) {
        List<Stop> stops = stopRepository.getStopsWithScooters();

        List<Stop> closeStopWithScooters = new ArrayList<Stop>();
        for (Stop stop : stops) {
            String location = stop.getLocation();
            float distanceToStopToAdd = this.getDistance(location, x, y);

            if (closeStopWithScooters.isEmpty() || closeStopWithScooters.size() < 5)
                closeStopWithScooters.add(stop);
            else {
                float distanceMax = 0.0F;
                Stop stopToDelete = null;
                for(Stop aux : closeStopWithScooters){
                    String locationAux = aux.getLocation();
                    float distanceToStopAdded = this.getDistance(locationAux, x, y);

                    if (distanceMax < distanceToStopAdded){
                        distanceMax = distanceToStopAdded;
                        stopToDelete = aux;
                    }
                }
                if (distanceToStopToAdd < distanceMax){
                    closeStopWithScooters.remove(stopToDelete);
                    closeStopWithScooters.add(stop);
                }
            }
        }

        return closeStopWithScooters;
    }

    public Stop createStop(Stop stop) {
        return stopRepository.save(stop);
    }

    public void deleteStop(Long id) {
        stopRepository.deleteById(id);
    }

    public Stop updateStop(Long id, Stop stop) {
        Optional<Stop> existingStop = stopRepository.findById(id);
        if (existingStop.isPresent()) {
            Stop updatedStop = existingStop.get();
            updatedStop.setLocation(stop.getLocation());
            updatedStop.setSlots(stop.getSlots());
            updatedStop.setEmpty(stop.isEmpty());
            updatedStop.setScooterList(stop.getScooterList());
            return stopRepository.save(updatedStop);
        }
        return null;
    }

    public Stop getStopById(Long id) {
        return stopRepository.findById(id).orElse(null);
    }

    public List<Stop> getAllStops() {
        return stopRepository.findAll();
    }

    private float getDistance (String location, float x, float y) {
        location = location.replace("(", "").replace(")", "");
        String[] coordinates = location.split(",");
        float stopX = Float.parseFloat(coordinates[0].trim());
        float stopY = Float.parseFloat(coordinates[1].trim());

        return this.calculateDistance(stopX, stopY, x, y);
    }

    private float calculateDistance(float x1, float y1, float x2, float y2) {
        return (float) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
