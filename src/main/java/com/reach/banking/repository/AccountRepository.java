package com.reach.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reach.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
