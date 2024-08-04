package com.example.user_service.model;

import java.util.UUID;

public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String name;  // e.g., "view_course", "edit_course"
}
