package com.example.payment_service.model;

import java.time.LocalDateTime;

public class Payment {
    @Id
    private UUID paymentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private double amount;
    private String status;
    private String transactionId;
    private LocalDateTime paymentDate;
}
