package com.example.user_service.service.serviceImpl;

import com.example.user_service.model.UserRole;
import com.example.user_service.repository.UserRoleRepository;
import com.example.user_service.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getAllUserRoles() {
        return userRoleRepository.findAll();
    }

    @Override
    public Optional<UserRole> getUserRoleById(UUID userRoleId) {
        return userRoleRepository.findById(userRoleId);
    }

    @Override
    public UserRole createUserRole(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void deleteUserRole(UUID userRoleId) {
        userRoleRepository.deleteById(userRoleId);
    }
}
