package com.example.user_service.model;

import jakarta.persistence.Id;

import java.util.UUID;

public class Permission {
    @Id
    private UUID permId;

    private String name;

}
