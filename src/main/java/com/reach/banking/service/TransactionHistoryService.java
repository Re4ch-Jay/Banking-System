package com.reach.banking.service;

import java.util.List;

import com.reach.banking.model.TransactionHistory;

public interface TransactionHistoryService {
    List<TransactionHistory> findAllTransactionHistoriesByAccountId(Long id);

    TransactionHistory create(TransactionHistory transactionHistory);
}
