package com.reach.banking.service;

import com.reach.banking.model.Account;

public interface AccountService {

    Account findById(Long id);

    Account create(Account account);

    Account update(Long id, Account account);

    void delete(Long id);


}
