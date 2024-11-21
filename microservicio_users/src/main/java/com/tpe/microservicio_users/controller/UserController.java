package com.tpe.microservicio_users.controller;

import com.tpe.microservicio_users.entity.UserAccount;
import com.tpe.microservicio_users.repository.UserRepository;
import com.tpe.microservicio_users.service.UserAccountService;
import com.tpe.microservicio_users.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tpe.microservicio_users.entity.User;


import java.util.List;

@Api(tags = "User Management")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserService userService;
    @Autowired
    public UserAccountService userAccountService;
    @Autowired
    private UserRepository userRepository;

    // {{base-url}}/api/users/{id}/account/{accountId}
    @ApiOperation(value = "se creo un nuevo usuario")
    @PostMapping("/{id}/account/{accountId}")
    public ResponseEntity<String> linkUserToAccount(@PathVariable Long id, @PathVariable Long accountId) {
        try {
            UserAccount userAccount = userAccountService.linkUserToAccount(id, accountId);
            return new ResponseEntity<>("Cuenta vinculada exitosamente.", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("Fallo al vincular la cuenta: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // {{base-url}}/api/users/{id}/account/{accountId}
    @ApiOperation(value = "el usuario se elimno con exito")
    @DeleteMapping("/{id}/account/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable long id, @PathVariable long accountId) {
            if (userService.deleteAccount(id, accountId))
                return ResponseEntity.status(HttpStatus.OK).body("Cuenta dada de baja");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cuenta no dada de baja");
    }

    // {{base-url}}/api/users/{id}/rol
    @GetMapping("{id}/rol")
    //to do: borrar
    public ResponseEntity<?> getRol(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.getRol(id));
    }

    // {{base-url}}/api/users
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

    // {{base-url}}/api/users
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

    // {{base-url}}/api/users
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
