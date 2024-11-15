package com.tpe.microservicio_travels.controller;


import com.tpe.microservicio_travels.dto.TravelsYearDTO;
import com.tpe.microservicio_travels.entity.Travel;
import com.tpe.microservicio_travels.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/travels")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/admin/scooters")
    public ResponseEntity<?> getScootersByMinTravels(@RequestParam("year") int year,  @RequestParam("minTravels") int minTravels){
        List<TravelsYearDTO> travelsYearDTOS = travelService.getScootersByMinTravels(year,minTravels);
        return ResponseEntity.status(HttpStatus.OK).body(travelsYearDTOS);
    }


    @GetMapping
    public ResponseEntity<List<Travel>> getAllTravels() {
        List<Travel> travels = travelService.findAll();
        return new ResponseEntity<>(travels, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Travel> getTravelById(@PathVariable Long id) {
        Optional<Travel> travel = travelService.findById(id);
        return travel.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Travel> createTravel(@RequestBody Travel travel) {
        Travel newTravel = travelService.save(travel);
        return new ResponseEntity<>(newTravel, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Travel> updateTravel(@PathVariable Long id, @RequestBody Travel travelDetails) {
        Optional<Travel> travelData = travelService.findById(id);

        if (travelData.isPresent()) {
            Travel travel = travelData.get();
            travel.setStartDate(travelDetails.getStartDate());
            travel.setEndDate(travelDetails.getEndDate());
            travel.setState(travelDetails.getState());
            travel.setStopStartId(travelDetails.getStopStartId());
            travel.setStopDestinyId(travelDetails.getStopDestinyId());
            travel.setScooterId(travelDetails.getScooterId());
            travel.setUserId(travelDetails.getUserId());
            travel.setStops(travelDetails.getStops());

            return new ResponseEntity<>(travelService.save(travel), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTravel(@PathVariable Long id) {
        try {
            travelService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
