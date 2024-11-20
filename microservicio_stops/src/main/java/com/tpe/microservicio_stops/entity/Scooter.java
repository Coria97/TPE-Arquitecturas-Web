package com.tpe.microservicio_stops.entity;

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
    @ManyToOne (fetch = FetchType.EAGER)
    private Stop stop;
}
