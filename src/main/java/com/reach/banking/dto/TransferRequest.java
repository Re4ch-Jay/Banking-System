package com.reach.banking.dto;

import lombok.Data;

@Data
public class TransferRequest {
    private Long receiverId;
    private Double amount;
}
