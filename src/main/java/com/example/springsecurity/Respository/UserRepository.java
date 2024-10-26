package com.example.springsecurity.Respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecurity.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);
    
}
