package com.tpe.microservicio_travels.controller;

import com.tpe.microservicio_travels.entity.TravelStop;
import com.tpe.microservicio_travels.service.TravelStopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/travel-stops")
public class TravelStopController {

    private final TravelStopService travelStopService;

    @Autowired
    public TravelStopController(TravelStopService travelStopService) {
        this.travelStopService = travelStopService;
    }

    @GetMapping
    public ResponseEntity<List<TravelStop>> getAllTravelStops() {
        List<TravelStop> travelStops = travelStopService.findAll();
        return new ResponseEntity<>(travelStops, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TravelStop> getTravelStopById(@PathVariable Long id) {
        Optional<TravelStop> travelStop = travelStopService.findById(id);
        return travelStop.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TravelStop> createTravelStop(@RequestBody TravelStop travelStop) {
        TravelStop newTravelStop = travelStopService.save(travelStop);
        return new ResponseEntity<>(newTravelStop, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTravelStop(@PathVariable Long id) {
        try {
            travelStopService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
