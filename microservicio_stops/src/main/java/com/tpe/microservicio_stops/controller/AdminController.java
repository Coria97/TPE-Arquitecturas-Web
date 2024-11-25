package com.tpe.microservicio_stops.controller;

import com.tpe.microservicio_stops.dto.ScooterStatesDTO;
import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.repository.ScooterRepository;
import com.tpe.microservicio_stops.repository.StopRepository;
import com.tpe.microservicio_stops.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    // {{base-url}}/api/admin/scooters/state
    @GetMapping("/scooters/state")
    public ResponseEntity<?> getScootersStates(){
        List<ScooterStatesDTO> response = adminService.getScooterStates();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}