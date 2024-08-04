package com.example.payment_service.model;

import java.time.LocalDateTime;

public class Payment {
    private String id;

    private String userId;
    private String courseId;

    private double amount;
    private String status;
    private String transactionId;
    LocalDateTime paymentDate;
}
