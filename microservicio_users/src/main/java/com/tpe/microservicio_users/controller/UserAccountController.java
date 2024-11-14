package com.tpe.microservicio_users.controller;

import com.tpe.microservicio_users.entity.UserAccount;
import com.tpe.microservicio_users.entity.UserAccountPK;
import com.tpe.microservicio_users.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useraccounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    // Obtener todos los UserAccounts
    @GetMapping
    public List<UserAccount> getAllUserAccounts() {
        return userAccountService.getAllUserAccounts();
    }

    // Obtener un UserAccount por ID (combinación de userId y accountId)
    @GetMapping("/{userId}/{accountId}")
    public ResponseEntity<UserAccount> getUserAccountById(@PathVariable Long userId, @PathVariable Long accountId) {
        UserAccountPK id = new UserAccountPK();
        id.setUserId(userId);
        id.setAccountId(accountId);
        return userAccountService.getUserAccountById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo UserAccount
    @PostMapping
    public UserAccount createUserAccount(@RequestBody UserAccount userAccount) {
        return userAccountService.createUserAccount(userAccount);
    }

    // Eliminar un UserAccount por ID (combinación de userId y accountId)
    @DeleteMapping("/{userId}/{accountId}")
    public ResponseEntity<Void> deleteUserAccount(@PathVariable Long userId, @PathVariable Long accountId) {
        UserAccountPK id = new UserAccountPK();
        id.setUserId(userId);
        id.setAccountId(accountId);
        userAccountService.deleteUserAccount(id);
        return ResponseEntity.noContent().build();
    }
}
