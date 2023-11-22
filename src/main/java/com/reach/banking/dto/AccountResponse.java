package com.reach.banking.dto;

import java.util.Date;

import lombok.Data;

@Data
public class AccountResponse {
    private String message;
    private Long accountId;
    private String firstName;
    private String lastName;
    private Double balance;
    private Integer statusCode;
    private Date date;
}
