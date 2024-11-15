package com.tpe.microservicio_travels.dto;

import lombok.Data;

@Data
public class ScooterStatsUpdateDTO {
    private float km;
    private float timeUsage;

    public ScooterStatsUpdateDTO(float km, float timeUsage) {
        this.km = km;
        this.timeUsage = timeUsage;
    }
}
