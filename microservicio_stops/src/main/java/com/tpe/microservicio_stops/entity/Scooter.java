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
    private float km;
    @Column
    private float time;
    @Column
    private float timeOut;
    @Column
    private String state;
    @ManyToOne (fetch = FetchType.EAGER)
    private Stop stop;
}
