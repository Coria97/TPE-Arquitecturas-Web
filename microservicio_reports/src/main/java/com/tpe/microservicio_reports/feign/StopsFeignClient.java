package com.tpe.microservicio_reports.feign;

import com.tpe.microservicio_reports.dto.ReportScooterUsageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name="microservicio_stops")
public interface StopsFeignClient {

    @GetMapping("/api/scooter")
    List<ReportScooterUsageDTO> getScootersUsage();
}
