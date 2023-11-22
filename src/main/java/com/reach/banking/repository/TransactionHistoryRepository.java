package com.reach.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reach.banking.model.TransactionHistory;

public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, Long> {

    List<TransactionHistory> findByAccountId(Long id);
}
