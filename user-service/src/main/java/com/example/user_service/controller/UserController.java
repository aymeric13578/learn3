package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable("user_id") UUID userId) {
        Optional<User> user = userService.getUserById(userId);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable("user_id") UUID userId, @RequestBody User userDetails) {
        return ResponseEntity.ok(userService.updateUser(userId, userDetails));
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("user_id") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{user_id}/reset-password")
    public ResponseEntity<Void> resetPassword(@PathVariable("user_id") UUID userId) {
        // Implement Keycloak admin API call to reset the password
        userService.resetPassword(userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{user_id}/change-password")
    public ResponseEntity<Void> changePassword(@PathVariable("user_id") UUID userId, @RequestParam String newPassword) {
        // Implement Keycloak admin API call to change the password
        userService.changePassword(userId, newPassword);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestParam String username, @RequestParam String password) {
        // Keycloak handles authentication and returns a token
        return ResponseEntity.ok(userService.authenticateUser(username, password));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(@RequestParam String refreshToken) {
        // Keycloak handles token refresh and returns a new access token
        return ResponseEntity.ok(userService.refreshToken(refreshToken));
    }
}
