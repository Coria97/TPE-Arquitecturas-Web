package com.tpe.microservicio_users.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;

    public String toString(){
        return "Username: " + username + ", Password: [FORBIDDEN] ";
    }
}
