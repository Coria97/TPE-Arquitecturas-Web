package com.tpe.microservicio_stops.dto;

import lombok.Data;

@Data
public class ScooterUsageDTO {
    private int id;
    private float km;
    private float timeOut;
}
