package com.reach.banking.exception;

public class InsufficientFund extends RuntimeException{
    public InsufficientFund(String messaage) {
        super(messaage);
    }
}
