package com.tpe.microservicio_users.service;

import com.tpe.microservicio_users.entity.User;
import com.tpe.microservicio_users.entity.Account;
import com.tpe.microservicio_users.entity.UserAccount;
import com.tpe.microservicio_users.entity.UserAccountPK;
import com.tpe.microservicio_users.repository.UserRepository;
import com.tpe.microservicio_users.repository.AccountRepository;
import com.tpe.microservicio_users.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    public UserAccount linkUserToAccount(Long userId, Long accountId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));

        UserAccount userAccount = new UserAccount();
        UserAccountPK userAccountPK = new UserAccountPK();
        userAccountPK.setUserId(userId);
        userAccountPK.setAccountId(accountId);
        userAccount.setId(userAccountPK);
        userAccount.setUser(user);
        userAccount.setAccount(account);

        return userAccountRepository.save(userAccount);
    }
}
