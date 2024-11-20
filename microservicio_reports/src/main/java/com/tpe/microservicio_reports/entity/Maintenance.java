package com.tpe.microservicio_reports.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;

@Data
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String state;
    @Column
    private Date dateMaintenance;
    @Column
    private String observation;
    @Column
    private Long scooterId;
}
