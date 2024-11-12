package com.tpe.microservicio_reports.repository;

import com.tpe.microservicio_reports.dto.ReportScooterUsageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<ReportScooterUsageDTO,Long> {



}
