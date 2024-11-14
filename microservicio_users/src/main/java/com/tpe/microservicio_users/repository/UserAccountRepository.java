package com.tpe.microservicio_users.repository;

import com.tpe.microservicio_users.entity.UserAccount;
import com.tpe.microservicio_users.entity.UserAccountPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, UserAccountPK> {
}
