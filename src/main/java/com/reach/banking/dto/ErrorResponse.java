package com.reach.banking.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private Integer statusCode;
    private Date date;
}
