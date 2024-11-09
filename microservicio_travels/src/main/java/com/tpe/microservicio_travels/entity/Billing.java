package com.tpe.microservicio_travels.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private int amount;
    @Column
    private int amountDebt;
    @Column
    private String state;
    @Column
    private int accountId;
    @ManyToOne(fetch = FetchType.LAZY)
    private BillingMethod billingMethod;
}
