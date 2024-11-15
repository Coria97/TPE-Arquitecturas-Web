package com.tpe.microservicio_users.utils;

import com.tpe.microservicio_users.enums.Rol;
import com.tpe.microservicio_users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUtils {

    private final UserRepository userRepository;

    @Autowired
    public UserUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isAdmin(int userId) {
        return userRepository.getRol(userId).equalsIgnoreCase(Rol.ADMIN.toString());
    }
}
