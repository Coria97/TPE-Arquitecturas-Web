package com.tpe.microservicio_stops.repository;

import com.tpe.microservicio_stops.dto.ScooterUsageDTO;
import com.tpe.microservicio_stops.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Long> {

    @Query("SELECT s.id, s.km, s.timeOut FROM Scooter s")
    public List<ScooterUsageDTO> getScootersUsage();
}
