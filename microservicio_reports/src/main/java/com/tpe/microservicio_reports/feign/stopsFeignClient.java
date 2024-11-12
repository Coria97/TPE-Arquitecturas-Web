package com.tpe.microservicio_reports.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="microservicio_stops")
public class stopsFeignClient {
    @GetMapping("/api/scooters")

}
