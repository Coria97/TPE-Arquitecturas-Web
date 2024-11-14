package com.tpe.microservicio_users.utils;

import com.tpe.microservicio_users.enums.Rol;
import com.tpe.microservicio_users.repository.UserRepository;

public class UserUtils {
    private UserRepository userRepository;

    public boolean isAdmin(int userId){
        return userRepository.getRol(userId).equalsIgnoreCase(Rol.ADMIN.toString());
    }
}
