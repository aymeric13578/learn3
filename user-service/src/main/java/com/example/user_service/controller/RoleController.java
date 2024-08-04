package com.example.user_service.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable UUID id) {
        return roleService.getRoleById(id).orElseThrow();
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping("/{roleId}/permissions/{permissionId}")
    public void addPermissionToRole(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        roleService.addPermissionToRole(roleId, permissionId);
    }

    @DeleteMapping("/{roleId}/permissions/{permissionId}")
    public void removePermissionFromRole(@PathVariable UUID roleId, @PathVariable UUID permissionId) {
        roleService.removePermissionFromRole(roleId, permissionId);
    }
}
