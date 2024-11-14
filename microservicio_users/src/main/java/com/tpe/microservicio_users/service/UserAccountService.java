package com.tpe.microservicio_users.service;

import com.tpe.microservicio_users.entity.UserAccount;
import com.tpe.microservicio_users.entity.UserAccountPK;
import com.tpe.microservicio_users.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> getAllUserAccounts() {
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> getUserAccountById(UserAccountPK id) {
        return userAccountRepository.findById(id);
    }

    public UserAccount createUserAccount(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    public void deleteUserAccount(UserAccountPK id) {
        userAccountRepository.deleteById(id);
    }
}
