package com.tpe.microservicio_users.service;

import com.tpe.microservicio_users.entity.UserAccountPK;
import com.tpe.microservicio_users.repository.AccountRepository;
import com.tpe.microservicio_users.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.tpe.microservicio_users.entity.User;
import com.tpe.microservicio_users.repository.UserRepository;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public boolean deleteAccount(long userId, long accountId){
        try{
            UserAccountPK userAccountPK = new UserAccountPK();
            userAccountPK.setUserId(userId);
            userAccountPK.setAccountId(accountId);
            userAccountRepository.deleteById(userAccountPK);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFirstName(updatedUser.getFirstName());
            user.setLastName(updatedUser.getLastName());
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPhoneNumber(updatedUser.getPhoneNumber());
            user.setRol(updatedUser.getRol());
            return userRepository.save(user);
        }).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
