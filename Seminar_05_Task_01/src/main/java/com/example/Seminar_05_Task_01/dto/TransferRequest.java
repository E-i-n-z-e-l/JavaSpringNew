package com.example.Seminar_05_Task_01.dto;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class TransferRequest {
    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;
}
