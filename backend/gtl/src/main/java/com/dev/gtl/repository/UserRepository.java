package com.dev.gtl.repository;

import com.dev.gtl.model.user.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
