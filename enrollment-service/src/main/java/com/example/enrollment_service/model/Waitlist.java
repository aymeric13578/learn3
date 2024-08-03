package com.example.enrollment_service.model;

@Entity
public class Waitlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String courseId;
    private String joinDate;
}
