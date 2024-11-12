package com.tpe.microservicio_reports.controller;

import com.tpe.microservicio_reports.dto.ReportScooterUsageDTO;
import com.tpe.microservicio_reports.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.ResponseEntity;

/*
* a. Como encargado de mantenimiento quiero poder generar un reporte de uso de monopatines por
kilómetros para establecer si un monopatín requiere de mantenimiento. Este reporte debe poder
configurarse para incluir (o no) los tiempos de pausa.
* */

@RestController
@RequestMapping("/api/report")
public class ReportsController {

    @Autowired
    private ReportsService service;

    @GetMapping("/scooter")
    public ResponseEntity<List<ReportScooterUsageDTO>> scooterReport(@RequestParam("timeOut") boolean timeOut){

        List<ReportScooterUsageDTO> reportScooter = this.service.getUsageScooters(timeOut);
        if(reportScooter.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(reportScooter);
    }
}
