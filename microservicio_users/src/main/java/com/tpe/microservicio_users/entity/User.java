package com.tpe.microservicio_users.entity;

import com.tpe.microservicio_users.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String username;
    @Column
    private String email;
    @Column
    private int phoneNumber;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @OneToMany(mappedBy="account", fetch = FetchType.LAZY)
    private List<UserAccount> accountList;
}
