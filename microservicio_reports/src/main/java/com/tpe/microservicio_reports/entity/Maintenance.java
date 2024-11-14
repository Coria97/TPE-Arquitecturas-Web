package com.tpe.microservicio_reports.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String state;
    @Column
    private Date dateMaintenance;
    @Column
    private String observation;

}
