package com.tpe.microservicio_stops.service;

import com.tpe.microservicio_stops.dto.ScooterStatesDTO;
import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.repository.ScooterRepository;
import com.tpe.microservicio_stops.repository.StopRepository;
import com.tpe.microservicio_stops.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private ScooterRepository scooterRepository;
    @Autowired
    private UserUtil userUtil;
    @Autowired
    private StopRepository stopRepository;

    public List<ScooterStatesDTO> getScooterStates(Long userId) {
        if (!userUtil.isAdmin(userId))
            return null;
        return scooterRepository.getScooterStates();
    }
}
