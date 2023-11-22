package com.reach.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reach.banking.exception.NotFoundException;
import com.reach.banking.model.Account;
import com.reach.banking.repository.AccountRepository;
import com.reach.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
    }

    @Override
    public Account create(Account account) {
        Account newAccount = new Account();
        newAccount.setFirstName(account.getFirstName());
        newAccount.setLastName(account.getLastName());
        newAccount.setBalance(account.getBalance());
        accountRepository.save(newAccount);
        return newAccount;
    }

    @Override
    public Account update(Long id, Account account) {
        Account updateAccount = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Account not found"));

        updateAccount.setFirstName(account.getFirstName());
        updateAccount.setLastName(account.getLastName());
        updateAccount.setBalance(updateAccount.getBalance());

        accountRepository.save(updateAccount);
        return updateAccount;
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
        accountRepository.delete(account);

    }

}
