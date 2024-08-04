package com.example.user_service.service;

@Service
@Transactional
public class RoleService {
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RoleService(RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Optional<Role> getRoleById(UUID id) {
        return roleRepository.findById(id);
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public void addPermissionToRole(UUID roleId, UUID permissionId) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        Permission permission = permissionRepository.findById(permissionId).orElseThrow();
        role.getPermissions().add(permission);
        roleRepository.save(role);
    }

    public void removePermissionFromRole(UUID roleId, UUID permissionId) {
        Role role = roleRepository.findById(roleId).orElseThrow();
        Permission permission = permissionRepository.findById(permissionId).orElseThrow();
        role.getPermissions().remove(permission);
        roleRepository.save(role);
    }
}
