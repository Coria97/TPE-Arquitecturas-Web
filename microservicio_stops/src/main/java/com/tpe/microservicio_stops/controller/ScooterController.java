package com.tpe.microservicio_stops.controller;


import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/scooter")
public class ScooterController {

    @Autowired
    private ScooterService scooterService;

    @GetMapping("/usage")
    public ResponseEntity<List<ScooterUsageDTO>> getScootersUsage(){
        return ResponseEntity.status(HttpStatus.OK).body(scooterService.getScootersUsage());
    }


}
