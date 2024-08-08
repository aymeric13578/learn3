package com.example.user_service.service;

import com.example.user_service.model.Permission;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PermissionService {
    List<Permission> getAllPermissions();
    Optional<Permission> getPermissionById(UUID permId);
    Permission createPermission(Permission permission);
    Permission updatePermission(UUID permId, Permission permissionDetails);
    void deletePermission(UUID permId);
}
