package com.tpe.microservicio_travels.controller;


import com.tpe.microservicio_travels.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/travel")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/scooters")
    public ResponseEntity<List<Integer>> getScootersByMinTravels(@RequestParam("year") int year,  @RequestParam("minTravel") int minTravels){
        return ResponseEntity.status(HttpStatus.OK).body(travelService.getScootersByMinTravels(year, minTravels));
    }

}
