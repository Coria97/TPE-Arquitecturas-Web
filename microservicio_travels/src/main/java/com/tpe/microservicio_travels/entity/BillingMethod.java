package com.tpe.microservicio_travels.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class BillingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private float price;
    @Column
    private String type;
    @OneToMany
    private List<Billing> billings;
}
