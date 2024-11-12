package com.tpe.microservicio_users.controller;

import com.netflix.discovery.converters.Auto;
import com.tpe.microservicio_users.service.UserService;
import com.tpe.microservicio_users.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    private UserUtils userUtils;

    @DeleteMapping("/{userId}/account/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable int userId, @PathVariable int accountId) {
        if (userUtils.isAdmin(userId)){
            if (userService.deleteAccount(accountId))
                return ResponseEntity.status(HttpStatus.OK).body("Cuenta dada de baja");
            else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cuenta no dada de baja");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No tiene permisos");

    }
}
