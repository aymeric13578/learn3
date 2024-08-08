package com.example.user_service.service.serviceImpl;

import com.example.user_service.model.Permission;
import com.example.user_service.repository.PermissionRepository;
import com.example.user_service.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Optional<Permission> getPermissionById(UUID permId) {
        return permissionRepository.findById(permId);
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission updatePermission(UUID permId, Permission permissionDetails) {
        return permissionRepository.findById(permId).map(permission -> {
            permission.setName(permissionDetails.getName());
            return permissionRepository.save(permission);
        }).orElseThrow(() -> new RuntimeException("Permission not found with id " + permId));
    }

    @Override
    public void deletePermission(UUID permId) {
        permissionRepository.deleteById(permId);
    }
}

