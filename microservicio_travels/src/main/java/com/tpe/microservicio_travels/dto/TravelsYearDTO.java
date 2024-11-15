package com.tpe.microservicio_travels.dto;


import lombok.Data;

@Data
public class TravelsYearDTO {

    private int scooterId;
    private Long cantViajes;

    public TravelsYearDTO( int scooterId, Long cantViajes) {
        this.scooterId = scooterId;
        this.cantViajes = cantViajes;
    }
}
