package com.tpe.microservicio_stops.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String code;
    @Column
    //Esta variable representa los km de todos los viajes.
    private float km;
    //Esta variable representa el tiempo total en pausa de todos los viajes.
    @Column
    private float timeUsage;
    @Column
    //To do: hacer enum, estado ocupado, disponible o mantenimiento
    private String state;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stop_id")
    @JsonIgnore
    private Stop stop;

    @JsonInclude
    public Long getStopId() {
        return stop != null ? stop.getId() : null;
    }
}
