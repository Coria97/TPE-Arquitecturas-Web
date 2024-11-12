package com.tpe.microservicio_reports.service;

import com.tpe.microservicio_reports.dto.ReportScooterUsageDTO;
import com.tpe.microservicio_reports.feign.StopsFeignClient;
import com.tpe.microservicio_reports.feign.TravelFeignClient;
import com.tpe.microservicio_reports.repository.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {

    @Autowired
    private ReportsRepository repository;
    @Autowired
    private StopsFeignClient stopsFeignClient;
    @Autowired
    private TravelFeignClient travelFeignClient;

    public List<ReportScooterUsageDTO> getUsageScooters(boolean timeOut){

        List<ReportScooterUsageDTO> ReportUsageScooters = stopsFeignClient.getScootersUsage();
        if(!timeOut){
            for(ReportScooterUsageDTO rso : ReportUsageScooters ){
                rso.setTimeOut(-1);
            }
        }
        return ReportUsageScooters;
    }

    public List<Integer> getScootersByMinTravels(int year, int minTravels){
        return travelFeignClient.getScootersByMinTravels(year, minTravels);
    }


}
