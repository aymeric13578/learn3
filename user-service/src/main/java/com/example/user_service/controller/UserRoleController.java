package com.example.user_service.controller;

import com.example.user_service.model.UserRole;
import com.example.user_service.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<UserRole> createUserRole(@RequestBody UserRole userRole) {
        return ResponseEntity.ok(userRoleService.createUserRole(userRole));
    }

    @GetMapping
    public List<UserRole> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{user_role_id}")
    public ResponseEntity<UserRole> getUserRoleById(@PathVariable("user_role_id") UUID userRoleId) {
        Optional<UserRole> userRole = userRoleService.getUserRoleById(userRoleId);
        return userRole.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{user_role_id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable("user_role_id") UUID userRoleId) {
        userRoleService.deleteUserRole(userRoleId);
        return ResponseEntity.noContent().build();
    }
}
