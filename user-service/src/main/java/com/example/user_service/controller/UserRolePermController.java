package com.example.user_service.controller;

import com.example.user_service.model.UserRolePerm;
import com.example.user_service.service.UserRolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-role-perms")
public class UserRolePermController {

    @Autowired
    private UserRolePermService userRolePermService;

    @PostMapping
    public ResponseEntity<UserRolePerm> createUserRolePerm(@RequestBody UserRolePerm userRolePerm) {
        return ResponseEntity.ok(userRolePermService.createUserRolePerm(userRolePerm));
    }

    @GetMapping
    public List<UserRolePerm> getAllUserRolePerms() {
        return userRolePermService.getAllUserRolePerms();
    }

    @GetMapping("/{user_role_perm_id}")
    public ResponseEntity<UserRolePerm> getUserRolePermById(@PathVariable("user_role_perm_id") UUID userRolePermId) {
        Optional<UserRolePerm> userRolePerm = userRolePermService.getUserRolePermById(userRolePermId);
        return userRolePerm.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{user_role_perm_id}")
    public ResponseEntity<Void> deleteUserRolePerm(@PathVariable("user_role_perm_id") UUID userRolePermId) {
        userRolePermService.deleteUserRolePerm(userRolePermId);
        return ResponseEntity.noContent().build();
    }
}
