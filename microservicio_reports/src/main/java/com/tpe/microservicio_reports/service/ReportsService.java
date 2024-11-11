package com.tpe.microservicio_reports.service;

import com.tpe.microservicio_reports.dto.ReportDTO;
import com.tpe.microservicio_reports.repository.ReportsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {

    private ReportsRepository repository;

    public List<ReportDTO> getUsageScooters(boolean timeOut){
        return this.repository.getUsageScooters();
    }



}
