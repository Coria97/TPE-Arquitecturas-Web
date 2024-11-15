package com.tpe.microservicio_travels.repository;

import com.tpe.microservicio_travels.dto.MonthBillingDTO;
import com.tpe.microservicio_travels.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {

    @Query("SELECT new com.tpe.microservicio_travels.dto.MonthBillingDTO(MONTH(b.billingDate), SUM(b.amount)) " +
            "FROM Billing b " +
            "WHERE YEAR(b.billingDate) = :year AND MONTH(b.billingDate) BETWEEN :startMonth AND :endMonth " +
            "GROUP BY MONTH(b.billingDate)")
    List<MonthBillingDTO> getBillingByMonthRange(@Param("year") int year, @Param("startMonth") int startMonth, @Param("endMonth") int endMonth);
}
