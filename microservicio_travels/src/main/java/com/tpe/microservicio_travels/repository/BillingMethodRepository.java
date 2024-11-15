package com.tpe.microservicio_travels.repository;

import com.tpe.microservicio_travels.entity.BillingMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface BillingMethodRepository extends JpaRepository<BillingMethod, Long> {
    @Query("SELECT bm FROM BillingMethod bm WHERE bm.type = :type AND :currentDate BETWEEN bm.perdiodStart AND bm.perdiodEnd")
    Optional<BillingMethod> findActiveBillingMethod(Date currentDate, String type);
}
