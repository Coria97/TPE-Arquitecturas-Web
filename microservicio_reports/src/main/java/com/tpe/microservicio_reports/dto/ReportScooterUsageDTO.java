package com.tpe.microservicio_reports.dto;

import lombok.Data;

@Data
public class ReportScooterUsageDTO {
    private int id;
    private float km;
    private float timeOut;

    public ReportScooterUsageDTO(int id, float km, int timeOut) {
        this.id = id;
        this.km = km;
        this.timeOut = timeOut;
    }

}
