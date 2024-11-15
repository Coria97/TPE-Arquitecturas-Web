package com.tpe.microservicio_travels.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class BillingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private float price;
    @Column
    private String type;
    @OneToMany
    @JsonIgnore
    private List<Billing> billings;
    @Column
    private Date perdiodStart;
    @Column
    private Date perdiodEnd;
}
