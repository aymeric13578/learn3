package com.example.user_service.service;

import com.example.user_service.model.UserRolePerm;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRolePermService {
    List<UserRolePerm> getAllUserRolePerms();
    Optional<UserRolePerm> getUserRolePermById(UUID userRolePermId);
    UserRolePerm createUserRolePerm(UserRolePerm userRolePerm);
    void deleteUserRolePerm(UUID userRolePermId);
}
