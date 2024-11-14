package com.tpe.microservicio_stops.dto;

import lombok.Data;

@Data
public class ScooterStatesDTO {

    private String state;
    private Long cantidad;

    public ScooterStatesDTO(String state, Long cantidad) {
        this.state = state;
        this.cantidad = cantidad;
    }
}
