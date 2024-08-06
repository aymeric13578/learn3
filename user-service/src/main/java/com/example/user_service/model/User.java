package com.example.user_service.model;

import java.util.List;

public class User {
    @Id
    private UUID userId;

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
