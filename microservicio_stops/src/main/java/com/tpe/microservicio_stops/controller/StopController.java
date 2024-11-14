package com.tpe.microservicio_stops.controller;

import com.tpe.microservicio_stops.entity.Stop;
import com.tpe.microservicio_stops.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stops")
public class StopController {

    @Autowired
    private StopService stopService;


    @PostMapping
    public ResponseEntity<Stop> createStop(@RequestBody Stop stop) {
        Stop createdStop = stopService.createStop(stop);
        return new ResponseEntity<>(createdStop, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStop(@PathVariable Long id) {
        stopService.deleteStop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stop> updateStop(@PathVariable Long id, @RequestBody Stop stop) {
        Stop updatedStop = stopService.updateStop(id, stop);
        if (updatedStop != null) {
            return new ResponseEntity<>(updatedStop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Stop> getStopById(@PathVariable Long id) {
        Stop stop = stopService.getStopById(id);
        if (stop != null) {
            return new ResponseEntity<>(stop, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    public ResponseEntity<List<Stop>> getAllStops() {
        List<Stop> stops = stopService.getAllStops();
        return new ResponseEntity<>(stops, HttpStatus.OK);
    }
}
