package com.tpe.microservicio_stops.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String code;
    @Column
    private float km;
    @Column
    private float timeUsage;
    @Column
    //Esta variable representa el tiempo total en pausa de todos los viajes. Por cada entrada en travelStop se sumara el tiempo de pausa.
    private float timeOut;
    @Column
    private String state;
    @ManyToOne (fetch = FetchType.EAGER)
    private Stop stop;
}
