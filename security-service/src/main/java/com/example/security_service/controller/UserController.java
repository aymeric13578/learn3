package com.example.security_service.controller;

import com.example.security_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}/reset-password")
    public void resetPassword(@PathVariable String userId) {
        userService.resetPassword(userId);
    }

    @PostMapping("/{userId}/change-password")
    public void changePassword(@PathVariable String userId, @RequestBody ChangePasswordRequest request) {
        userService.changePassword(userId, request.getNewPassword());
    }
}
