package com.reach.banking.dto;

import java.util.Date;

import com.reach.banking.model.Account;

import lombok.Data;

@Data
public class TransactionResponse {
    private String message;
    private Account accountResponse;
    private Integer statusCode;
    private Date date;
}
