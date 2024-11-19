package com.tpe.microservicio_travels.repository;

import com.tpe.microservicio_travels.dto.TravelsYearDTO;
import com.tpe.microservicio_travels.entity.Travel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long>{

    @Query("SELECT new com.tpe.microservicio_travels.dto.TravelsYearDTO(t.scooterId, count(t.scooterId)) " +
            "FROM Travel t " +
            "WHERE YEAR(t.startDate) = :year " +
            "GROUP BY t.scooterId " +
            "HAVING count(t.scooterId) > :minTravels")
    List<TravelsYearDTO> getScootersByMinTravels(@Param("year") int year, @Param("minTravels") int minTravels);

    @Modifying
    @Transactional
    @Query("update Travel t set t.endDate = :endDate, t.state = :state where t.id = :travelId")
    void finishTravel(@Param("travelId") Long travelId, @Param("endDate") Date endDate, @Param("state") String state);

}


