package com.reach.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reach.banking.service.TransactionHistoryService;

@RestController
@RequestMapping("/api/accounts")
public class TransactionHistoryController {

    @Autowired
    private TransactionHistoryService transactionHistoryService;

    @GetMapping("/{id}/history")
    public ResponseEntity<?> getTransactionhistoriesByAccountId(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(transactionHistoryService.findAllTransactionHistoriesByAccountId(id),
                HttpStatus.OK);
    }
}
