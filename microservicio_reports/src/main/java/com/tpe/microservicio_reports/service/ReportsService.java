package com.tpe.microservicio_reports.service;

import com.tpe.microservicio_reports.dto.ReportScooterUsageDTO;
import com.tpe.microservicio_reports.feign.StopsFeignClient;


import com.tpe.microservicio_reports.feign.TravelFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportsService {


    @Autowired
    private StopsFeignClient stopsFeignClient;

    @Autowired
    private TravelFeignClient travelFeignClient;

    public List<ReportScooterUsageDTO> getUsageScooters(boolean timeOut){
        List<ReportScooterUsageDTO> reportUsageScooters = stopsFeignClient.getScootersUsage();
        if(!timeOut){
            for(ReportScooterUsageDTO rso : reportUsageScooters ){
                // timeOut es de tipo float y no acepta null, entonces se le pone un valor no valido como -1
                rso.setTimeOut(-1);
            }
        }
        return reportUsageScooters;
    }

    public List<Integer> getScootersByMinTravels(int year, int minTravels){
        return travelFeignClient.getScootersByMinTravels(year, minTravels);
    }
}
