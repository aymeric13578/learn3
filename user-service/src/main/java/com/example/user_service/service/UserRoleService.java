package com.example.user_service.service;

import com.example.user_service.model.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRoleService {
    List<UserRole> getAllUserRoles();
    Optional<UserRole> getUserRoleById(UUID userRoleId);
    UserRole createUserRole(UserRole userRole);
    void deleteUserRole(UUID userRoleId);
}
