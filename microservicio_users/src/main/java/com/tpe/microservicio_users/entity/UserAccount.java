package com.tpe.microservicio_users.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class UserAccount {
    @EmbeddedId
    private UserAccountPK id;
    @ManyToOne
    @MapsId("userId")
    private User user;
    @ManyToOne
    @MapsId("accountId")
    private Account account;
}
