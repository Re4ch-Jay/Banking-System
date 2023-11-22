package com.reach.banking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reach.banking.model.TransactionHistory;
import com.reach.banking.repository.TransactionHistoryRepository;
import com.reach.banking.service.TransactionHistoryService;

@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {

    @Autowired
    private TransactionHistoryRepository transactionHistoryRepository;

    @Override
    public List<TransactionHistory> findAllTransactionHistoriesByAccountId(Long id) {
        List<TransactionHistory> transactionHistories = transactionHistoryRepository.findByAccountId(id);
        return transactionHistories;
    }

    @Override
    public TransactionHistory create(TransactionHistory transactionHistory) {

        transactionHistoryRepository.save(transactionHistory);
        return transactionHistory;
    }

}
