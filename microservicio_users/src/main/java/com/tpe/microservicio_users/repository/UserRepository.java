package com.tpe.microservicio_users.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository implements JpaRepository<User, Long> {

    @Query("SELECT u.rol FROM User u where u.id = :userId")
    String getRol(int userId);
}
