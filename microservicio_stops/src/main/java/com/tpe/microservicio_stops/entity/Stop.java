package com.tpe.microservicio_stops.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String location;
    @Column
    private int slots;
    @Column
    private boolean full;
    @OneToMany (fetch = FetchType.LAZY)
    private List<Scooter> scooterList;
}
