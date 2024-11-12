package com.tpe.microservicio_users.repository;

import com.tpe.microservicio_users.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.active = false WHERE a.id = :accountId")
    void deleteAccount(int accountId);
}
