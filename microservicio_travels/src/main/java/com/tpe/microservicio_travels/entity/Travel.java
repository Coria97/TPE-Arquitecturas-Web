package com.tpe.microservicio_travels.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Getter
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    // To do: Hacer enum en progreso, finalizado
    private String state;
    @Column
    private int stopStartId;
    @Column
    private int stopDestinyId;
    @Column
    private int scooterId;
    @Column
    private int userId;
    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
    private List<TravelStop> stops;
    @OneToOne(mappedBy = "travel")
    private Billing billing;
    @Column
    private float distance;
}
