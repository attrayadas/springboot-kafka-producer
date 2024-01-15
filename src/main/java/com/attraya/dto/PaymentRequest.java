package com.attraya.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {

    private String transactionId;
    private String sourceAccount;
    private String destinationAccount;
    private Integer amount;
    private Date transactionDate;
}
