package com.reach.banking.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reach.banking.exception.InsufficientFund;
import com.reach.banking.exception.NotFoundException;
import com.reach.banking.model.Account;
import com.reach.banking.model.TransactionHistory;
import com.reach.banking.model.TransactionType;
import com.reach.banking.repository.AccountRepository;
import com.reach.banking.service.TransactionHistoryService;
import com.reach.banking.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @Override
    public Account deposit(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
        account.setFirstName(account.getFirstName());
        account.setLastName(account.getLastName());
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAccount(account);
        transactionHistory.setAmount(amount);
        transactionHistory.setDate(new Date());
        transactionHistory.setTransactionType(TransactionType.DEPOSIT);

        transactionHistoryService.create(transactionHistory);

        return account;
    }

    @Override
    public Account withdraw(Long id, Double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
        if (account.getBalance() < amount) {
            throw new InsufficientFund("Insufficient Fund");
        }
        account.setFirstName(account.getFirstName());
        account.setLastName(account.getLastName());
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAccount(account);
        transactionHistory.setAmount(amount);
        transactionHistory.setDate(new Date());
        transactionHistory.setTransactionType(TransactionType.WITHDRAW);

        transactionHistoryService.create(transactionHistory);

        return account;
    }

    @Override
    public Account transfer(Long senderId, Long receiverId, Double amount) {
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new NotFoundException("Sender account not found"));
        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new NotFoundException("Receiver account not found"));

        if (sender.getBalance() < amount) {
            throw new InsufficientFund("Insufficient Fund");
        }

        sender.setFirstName(sender.getFirstName());
        sender.setLastName(sender.getLastName());
        sender.setBalance(sender.getBalance() - amount);
        accountRepository.save(sender);

        receiver.setFirstName(receiver.getFirstName());
        receiver.setLastName(receiver.getLastName());
        receiver.setBalance(receiver.getBalance() + amount);
        accountRepository.save(receiver);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAccount(sender);
        transactionHistory.setAmount(amount);
        transactionHistory.setDate(new Date());
        transactionHistory.setTransactionType(TransactionType.TRANSFER);

        transactionHistoryService.create(transactionHistory);
        return sender;
    }

    @Override
    public Account payment(Long payerId, Long receiverId, Double amount) {
        Account payer = accountRepository.findById(payerId)
                .orElseThrow(() -> new NotFoundException("Payer account not found"));
        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new NotFoundException("Receiver account not found"));

        if (payer.getBalance() < amount) {
            throw new InsufficientFund("Insufficient Fund");
        }

        payer.setFirstName(payer.getFirstName());
        payer.setLastName(payer.getLastName());
        payer.setBalance(payer.getBalance() - amount);
        accountRepository.save(payer);

        receiver.setFirstName(receiver.getFirstName());
        receiver.setLastName(receiver.getLastName());
        receiver.setBalance(receiver.getBalance() + amount);
        accountRepository.save(receiver);

        TransactionHistory transactionHistory = new TransactionHistory();
        transactionHistory.setAccount(payer);
        transactionHistory.setAmount(amount);
        transactionHistory.setDate(new Date());
        transactionHistory.setTransactionType(TransactionType.TRANSFER);

        transactionHistoryService.create(transactionHistory);
        return payer;
    }
}
