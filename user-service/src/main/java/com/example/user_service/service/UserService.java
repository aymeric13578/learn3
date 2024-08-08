package com.example.user_service.service;

import com.example.user_service.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(UUID userId);
    User createUser(User user);
    User updateUser(UUID userId, User userDetails);
    void deleteUser(UUID userId);
    void resetPassword(UUID userId);
    void changePassword(UUID userId, String newPassword);
    String authenticateUser(String username, String password);
    String refreshToken(String oldToken);
}