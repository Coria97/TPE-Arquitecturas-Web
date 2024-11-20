package com.tpe.microservicio_stops.repository;

import com.tpe.microservicio_stops.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {
    @Query( "SELECT s " +
            "FROM Stop s " +
            "WHERE s.isEmpty = false " +
            "AND EXISTS(" +
            "   SELECT 1 " +
            "   FROM Scooter sc " +
            "   WHERE sc.state = 'Available' AND sc.stop = s)"
    )
    List<Stop> getStopsWithScooters();
}
