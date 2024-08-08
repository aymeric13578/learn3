package com.example.security_service.service.impl;

import com.example.security_service.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public void resetPassword(String userId) {
        // Implement password reset logic
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        // Implement password change logic
    }
}