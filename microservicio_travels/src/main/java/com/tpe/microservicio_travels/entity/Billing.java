package com.tpe.microservicio_travels.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int amount;
    @Column
    private Date billingDate;
    @Column
    private int amountDebt;
    @Column
    private String state;
    @Column
    private Long accountId;
    @ManyToOne
    private BillingMethod billingMethod;
    @OneToOne
    @JoinColumn(name = "travel_id")
    private Travel travel;
}
