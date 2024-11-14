package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpe.microservicio_travels.entity.Travel;
import java.util.List;
import java.util.Optional;


@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;

    public List<Integer> getScootersByMinTravels(int year, int minTravels){
        return travelRepository.getScootersByMinTravels(year, minTravels);
    }

    public List<Travel> findAll() {
        return travelRepository.findAll();
    }

    public Optional<Travel> findById(Long id) {
        return travelRepository.findById(id);
    }

    public Travel save(Travel travel) {
        return travelRepository.save(travel);
    }

    public void deleteById(Long id) {
        travelRepository.deleteById(id);
    }

}
