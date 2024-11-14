package com.tpe.microservicio_stops.repository;

import com.tpe.microservicio_stops.entity.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {

}
