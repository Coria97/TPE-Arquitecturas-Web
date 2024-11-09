package com.tpe.microservicio_travels.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Data
@Entity
public class TravelStop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private Timestamp start;
    @Column
    private Timestamp end;
    @ManyToOne(fetch = FetchType.LAZY)
    private Travel travels;
}
