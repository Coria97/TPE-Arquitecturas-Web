package com.tpe.microservicio_reports.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
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

    public String getState() {
        return state;
    }

    public Date getDateMaintenance() {
        return dateMaintenance;
    }

    public String getObservation() {
        return observation;
    }


}
