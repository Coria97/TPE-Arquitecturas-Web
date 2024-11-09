package com.tpe.microservicio_users.entity;


import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UserAccountPK implements Serializable {
    private int userId;
    private int accountId;
}
