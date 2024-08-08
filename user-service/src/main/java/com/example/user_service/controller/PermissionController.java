package com.example.user_service.controller;

import com.example.user_service.model.Permission;
import com.example.user_service.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping
    public ResponseEntity<Permission> createPermission(@RequestBody Permission permission) {
        return ResponseEntity.ok(permissionService.createPermission(permission));
    }

    @GetMapping
    public List<Permission> getAllPermissions() {
        return permissionService.getAllPermissions();
    }

    @GetMapping("/{perm_id}")
    public ResponseEntity<Permission> getPermissionById(@PathVariable("perm_id") UUID permId) {
        Optional<Permission> permission = permissionService.getPermissionById(permId);
        return permission.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{perm_id}")
    public ResponseEntity<Permission> updatePermission(@PathVariable("perm_id") UUID permId, @RequestBody Permission permissionDetails) {
        return ResponseEntity.ok(permissionService.updatePermission(permId, permissionDetails));
    }

    @DeleteMapping("/{perm_id}")
    public ResponseEntity<Void> deletePermission(@PathVariable("perm_id") UUID permId) {
        permissionService.deletePermission(permId);
        return ResponseEntity.noContent().build();
    }
}
