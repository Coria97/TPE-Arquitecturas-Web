package com.tpe.microservicio_travels.entity;

import lombok.Data;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Data
@Entity
public class TravelStop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Timestamp start;
    @Column
    private Timestamp end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    private Travel travel;
}
