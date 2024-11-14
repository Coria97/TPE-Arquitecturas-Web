package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;

    public List<Integer> getScootersByMinTravels(int year, int minTravels){
        return travelRepository.getScootersByMinTravels(year, minTravels);
    }


}
