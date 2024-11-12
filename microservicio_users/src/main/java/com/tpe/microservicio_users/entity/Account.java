package com.tpe.microservicio_users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<UserAccount> userAccounts;
    @Column
    private boolean active;
    @Transient
    private List<User> users;

    @PostLoad
    public void loadUsers() {
        if (userAccounts != null) {
            users = userAccounts.stream()
                    .map(UserAccount::getUser)
                    .collect(Collectors.toList());
        }
    }
}
