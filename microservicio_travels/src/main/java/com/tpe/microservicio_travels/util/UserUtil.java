package com.tpe.microservicio_travels.util;

import com.tpe.microservicio_travels.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    @Autowired
    private UserFeignClient userFeignClient;

    public boolean isAdmin(Long userId) {
        ResponseEntity<?> response = userFeignClient.getUserRol(userId);

        if (response.getStatusCode() == HttpStatus.OK) {
            String role = (String) response.getBody();
            return "ADMIN".equals(role);
        }
        return false;
    }
}
