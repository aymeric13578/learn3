package com.example.user_service.repository;

public interface PermissionRepository extends JpaRepository<Permission, UUID>{
    Permission findByName(String name);
}
