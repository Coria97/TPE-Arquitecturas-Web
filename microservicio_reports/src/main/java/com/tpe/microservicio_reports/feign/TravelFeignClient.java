package com.tpe.microservicio_reports.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name="microservicio_travels")
public interface TravelFeignClient {

    @GetMapping("api/travel/scooters")
    List<Integer> getScootersByMinTravels(int year, int minTravels);
}
