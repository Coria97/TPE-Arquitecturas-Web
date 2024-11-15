package com.tpe.microservicio_travels.repository;

import com.tpe.microservicio_travels.entity.TravelStop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelStopRepository extends JpaRepository<TravelStop, Long> {
    List<TravelStop> findByTravelId(Long travelId);
}
