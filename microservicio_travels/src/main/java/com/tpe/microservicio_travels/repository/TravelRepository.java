package com.tpe.microservicio_travels.repository;

import com.tpe.microservicio_travels.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelRepository implements JpaRepository<Travel, Long> {

    @Query("SELECT t.scooterId FROM Travel t WHERE YEAR(t.startDate) = :year GROUP BY t.scooterId HAVING count(t.scooterId) > :minTravel")
    List<Integer> getScootersByMinTravels(int year, int minTravels);
}
