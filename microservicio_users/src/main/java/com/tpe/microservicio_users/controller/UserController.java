package com.tpe.microservicio_users.controller;

import com.tpe.microservicio_users.service.UserService;
import com.tpe.microservicio_users.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tpe.microservicio_users.entity.User;


import java.util.List;

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

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
