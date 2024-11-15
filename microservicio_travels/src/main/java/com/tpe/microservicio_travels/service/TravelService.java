package com.tpe.microservicio_travels.service;

import com.tpe.microservicio_travels.dto.TravelsYearDTO;
import com.tpe.microservicio_travels.repository.TravelRepository;
import com.tpe.microservicio_travels.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tpe.microservicio_travels.entity.Travel;
import java.util.List;
import java.util.Optional;


@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private UserUtil userUtil;

    public List<TravelsYearDTO> getScootersByMinTravels(Long userId, int year, int minTravels){
        if (!userUtil.isAdmin(userId))
            return null;
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
