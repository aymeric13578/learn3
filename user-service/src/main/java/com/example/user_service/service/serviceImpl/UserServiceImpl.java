package com.example.user_service.service.serviceImpl;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(UUID userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(UUID userId, User userDetails) {
        return userRepository.findById(userId).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void resetPassword(UUID userId) {
        // Implement password reset logic
    }

    @Override
    public void changePassword(UUID userId, String newPassword) {
        // Implement password change logic
    }

    @Override
    public String authenticateUser(String username, String password) {
        // Implement authentication and return JWT token
        return "";
    }

    @Override
    public String refreshToken(String oldToken) {
        // Implement token refresh logic
        return "";
    }
}
