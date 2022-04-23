package com.dev.gtl.repository;

import java.util.Optional;

import com.dev.gtl.model.user.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
    Optional<Account> findByEmail(String email);
}
