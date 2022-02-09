package com.empiretech.userservice.repository;

import com.empiretech.userservice.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserId(Long id);
    
}
