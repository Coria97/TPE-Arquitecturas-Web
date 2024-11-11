package com.tpe.microservicio_reports.repository;

import com.tpe.microservicio_reports.config.JpaConfig;
import com.tpe.microservicio_reports.dto.ReportDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<ReportDTO,Long> {

    @Query


}
