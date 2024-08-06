package com.example.payment_service.model;

import com.example.course_service.model.Course;
import com.example.user_service.model.User;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;
import java.util.UUID;

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
