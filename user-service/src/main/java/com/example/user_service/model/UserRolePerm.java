package com.example.user_service.model;

@Entity
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
