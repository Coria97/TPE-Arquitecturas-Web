package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.entity.TravelStop;
import com.tpe.microservicio_travels.repository.TravelStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelStopService {

    private final TravelStopRepository travelStopRepository;

    @Autowired
    public TravelStopService(TravelStopRepository travelStopRepository) {
        this.travelStopRepository = travelStopRepository;
    }

    public List<TravelStop> findAll() {
        return travelStopRepository.findAll();
    }

    public Optional<TravelStop> findById(Long id) {
        return travelStopRepository.findById(id);
    }

    public TravelStop save(TravelStop travelStop) {
        return travelStopRepository.save(travelStop);
    }

    public void deleteById(Long id) {
        travelStopRepository.deleteById(id);
    }
}
