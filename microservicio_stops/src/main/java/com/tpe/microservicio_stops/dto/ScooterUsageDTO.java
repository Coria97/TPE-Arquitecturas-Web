package com.tpe.microservicio_stops.dto;

import lombok.Data;

@Data
public class ScooterUsageDTO {
    private Long id;
    private float km;
    private float timeOut;

    public ScooterUsageDTO(Long id, Float km, Float timeOut) {
        this.id = id;
        this.km = km;
        this.timeOut = timeOut;
    }
}
