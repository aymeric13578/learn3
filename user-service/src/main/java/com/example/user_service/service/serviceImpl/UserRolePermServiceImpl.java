package com.example.user_service.service.serviceImpl;

import com.example.user_service.model.UserRolePerm;
import com.example.user_service.repository.UserRolePermRepository;
import com.example.user_service.service.UserRolePermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRolePermServiceImpl implements UserRolePermService {

    @Autowired
    private UserRolePermRepository userRolePermRepository;

    @Override
    public List<UserRolePerm> getAllUserRolePerms() {
        return userRolePermRepository.findAll();
    }

    @Override
    public Optional<UserRolePerm> getUserRolePermById(UUID userRolePermId) {
        return userRolePermRepository.findById(userRolePermId);
    }

    @Override
    public UserRolePerm createUserRolePerm(UserRolePerm userRolePerm) {
        return userRolePermRepository.save(userRolePerm);
    }

    @Override
    public void deleteUserRolePerm(UUID userRolePermId) {
        userRolePermRepository.deleteById(userRolePermId);
    }
}
