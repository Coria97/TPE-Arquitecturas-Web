package com.tpe.microservicio_users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private float balance;
    @Column
    private String mpAccount;
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<UserAccount> userList;
}
