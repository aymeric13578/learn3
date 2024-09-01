package com.example.user_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "user_role_perm")
@NoArgsConstructor
@AllArgsConstructor
public class UserRolePerm {
    @Id
    private UUID userRolePermId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "perm_id")
    private Permission permission;
}
