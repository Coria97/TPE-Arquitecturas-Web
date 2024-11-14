package com.tpe.microservicio_reports.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@FeignClient(name="microservicio-travels", url="http://localhost:8080")
public interface TravelFeignClient {

    @GetMapping("api/travel/scooters")
    List<Integer> getScootersByMinTravels(@RequestParam("year") int year,
                                          @RequestParam("minTravels") int minTravels);
}



