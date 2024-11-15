package com.tpe.microservicio_travels.feign;

import com.tpe.microservicio_travels.dto.ScooterStatsUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="microservicio-users",  url = "http://localhost:8081")
public interface ScooterFeignClient {
    @PutMapping("/api/scooter/{scooterId}/stats")
    void updateStatsScooter(@PathVariable Long id, @RequestBody ScooterStatsUpdateDTO scooterUpdateDTO);
}
