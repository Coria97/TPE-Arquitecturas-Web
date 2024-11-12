package com.tpe.microservicio_reports.service;

import com.tpe.microservicio_reports.dto.ReportDTO;
import com.tpe.microservicio_reports.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private ReportsRepository repository;

    public List<ReportDTO> getUsageScooters(boolean timeOut){

        return null;
    }



}
