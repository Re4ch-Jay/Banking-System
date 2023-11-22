package com.reach.banking.service;

import com.reach.banking.model.Account;

public interface TransactionService {
    Account deposit(Long id, Double amount);

    Account withdraw(Long id, Double amount);

    Account transfer(Long senderId, Long receiverId, Double amount);

    Account payment(Long payerId, Long receiverId, Double amount);
}
