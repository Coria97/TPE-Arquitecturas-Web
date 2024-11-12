package com.tpe.microservicio_stops.service;

import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.repository.ScooterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScooterService {

    @Autowired
    private ScooterRepository scooterRepository;

    public List<ScooterUsageDTO> getScootersUsage() {
        return scooterRepository.getScootersUsage();
    }


}