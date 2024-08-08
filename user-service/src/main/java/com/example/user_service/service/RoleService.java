package com.example.user_service.service;

import com.example.user_service.model.Role;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoleService {
    List<Role> getAllRoles();
    Optional<Role> getRoleById(UUID roleId);
    Role createRole(Role role);
    Role updateRole(UUID roleId, Role roleDetails);
    void deleteRole(UUID roleId);
}
