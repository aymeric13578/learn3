package com.example.user_service.service.serviceImpl;

import com.example.user_service.model.Role;
import com.example.user_service.repository.RoleRepository;
import com.example.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(UUID roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(UUID roleId, Role roleDetails) {
        return roleRepository.findById(roleId).map(role -> {
            role.setName(roleDetails.getName());
            return roleRepository.save(role);
        }).orElseThrow(() -> new RuntimeException("Role not found with id " + roleId));
    }

    @Override
    public void deleteRole(UUID roleId) {
        roleRepository.deleteById(roleId);
    }
}
