package com.tpe.microservicio_travels.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String state;
    @Column
    private int stopStartId;
    @Column
    private int stopDestinyId;
    @Column
    private int scooterId;
    @Column
    private int userId;
    @OneToMany
    private List<TravelStop> stops;

}
