package com.example.security_service.service;


public interface UserService {
    void resetPassword(String userId);
    void changePassword(String userId, String newPassword);
}
