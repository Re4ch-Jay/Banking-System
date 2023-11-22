package com.reach.banking.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reach.banking.dto.AccountResponse;
import com.reach.banking.model.Account;
import com.reach.banking.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable Long id) {

        Account account = accountService.findById(id);

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setMessage("Successfully find the account");
        accountResponse.setAccountId(id);
        accountResponse.setFirstName(account.getFirstName());
        accountResponse.setLastName(account.getLastName());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setStatusCode(HttpStatus.OK.value());
        accountResponse.setDate(new Date());

        return ResponseEntity.ok(accountResponse);
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {

        Account newAccount = accountService.create(account);

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setMessage("Successfully find the account");
        accountResponse.setAccountId(newAccount.getId());
        accountResponse.setFirstName(newAccount.getFirstName());
        accountResponse.setLastName(newAccount.getLastName());
        accountResponse.setBalance(newAccount.getBalance());
        accountResponse.setStatusCode(HttpStatus.OK.value());
        accountResponse.setDate(new Date());

        return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable Long id, @Valid @RequestBody Account account) {
        Account updateAccount = accountService.update(id, account);

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setMessage("Successfully find the account");
        accountResponse.setAccountId(updateAccount.getId());
        accountResponse.setFirstName(updateAccount.getFirstName());
        accountResponse.setLastName(updateAccount.getLastName());
        accountResponse.setBalance(updateAccount.getBalance());
        accountResponse.setStatusCode(HttpStatus.OK.value());
        accountResponse.setDate(new Date());

        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
    }

}
