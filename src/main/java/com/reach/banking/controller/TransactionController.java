package com.reach.banking.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reach.banking.dto.TransactionResponse;
import com.reach.banking.dto.TransferRequest;
import com.reach.banking.model.Account;
import com.reach.banking.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{id}/deposit")
    public ResponseEntity<?> deposit(@PathVariable Long id, @Valid @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");

        Account account = transactionService.deposit(id, amount);

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setMessage("Successfully deposit with the amount " + amount);
        transactionResponse.setAccountResponse(account);
        transactionResponse.setStatusCode(HttpStatus.CREATED.value());
        transactionResponse.setDate(new Date());

        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<?> withdraw(@PathVariable Long id, @Valid @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        Account account = transactionService.withdraw(id, amount);

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setMessage("Successfully deposit with the amount " + amount);
        transactionResponse.setAccountResponse(account);
        transactionResponse.setStatusCode(HttpStatus.CREATED.value());
        transactionResponse.setDate(new Date());
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{senderId}/transfer")
    public ResponseEntity<?> transfer(@PathVariable("senderId") Long senderId,
            @Valid @RequestBody TransferRequest transferRequest) {

        Double amount = transferRequest.getAmount();
        Long receiverId = transferRequest.getReceiverId();

        Account account = transactionService.transfer(senderId, receiverId, amount);

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setMessage(
                "Successfully transfer from " + senderId + "with the amount " + amount + " to the account with the id "
                        + receiverId);
        transactionResponse.setAccountResponse(account);
        transactionResponse.setStatusCode(HttpStatus.CREATED.value());
        transactionResponse.setDate(new Date());

        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{payerId}/payment")
    public ResponseEntity<?> payment(@PathVariable("payerId") Long payerId,
            @Valid @RequestBody TransferRequest transferRequest) {

        Double amount = transferRequest.getAmount();
        Long receiverId = transferRequest.getReceiverId();

        Account account = transactionService.transfer(payerId, receiverId, amount);

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setMessage(
                "Successfully payment from " + payerId + "with the amount " + amount + " to the account with the id "
                        + receiverId);
        transactionResponse.setAccountResponse(account);
        transactionResponse.setStatusCode(HttpStatus.CREATED.value());
        transactionResponse.setDate(new Date());

        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }
}
