package com.example.user_service.controller;

import com.example.user_service.model.Role;
import com.example.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.createRole(role));
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{role_id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("role_id") UUID roleId) {
        Optional<Role> role = roleService.getRoleById(roleId);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{role_id}")
    public ResponseEntity<Role> updateRole(@PathVariable("role_id") UUID roleId, @RequestBody Role roleDetails) {
        return ResponseEntity.ok(roleService.updateRole(roleId, roleDetails));
    }

    @DeleteMapping("/{role_id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("role_id") UUID roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }
}
