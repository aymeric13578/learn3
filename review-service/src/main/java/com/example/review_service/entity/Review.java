package com.example.review_service.entity;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String sentiment;
    private boolean isSpam;
    private boolean isApproved;
    // Getters and setters
}

