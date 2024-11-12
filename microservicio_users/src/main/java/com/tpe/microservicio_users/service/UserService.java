package com.tpe.microservicio_users.service;

import com.tpe.microservicio_users.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AccountRepository accountRepository;

    public boolean deleteAccount(int accountId){
        try{
            accountRepository.deleteAccount(accountId);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
