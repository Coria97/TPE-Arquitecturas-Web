package com.tpe.microservicio_users.entity;

import com.tpe.microservicio_users.enums.Rol;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true, nullable = false )
    private String username;
    @Column( nullable = false )
    private String password;
    @Column
    private String email;
    @Column
    private int phoneNumber;
    @Enumerated(EnumType.STRING)
    private Rol rol;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserAccount> userAccounts;
    @Transient
    private List<Account> accounts;

    @PostLoad
    public void loadAccounts() {
        if (userAccounts != null) {
            accounts = userAccounts.stream()
                    .map(UserAccount::getAccount)
                    .collect(Collectors.toList());
        }
    }
}
