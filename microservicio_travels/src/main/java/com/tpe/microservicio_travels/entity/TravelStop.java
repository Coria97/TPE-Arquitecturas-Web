package com.tpe.microservicio_travels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import jakarta.persistence.*;

import java.sql.Timestamp;


@Data
@Entity
public class TravelStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Timestamp start;
    @Column
    private Timestamp end;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id")
    @JsonIgnore
    private Travel travel;
}
