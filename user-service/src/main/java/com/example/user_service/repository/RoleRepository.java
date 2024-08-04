package com.example.user_service.repository;

public interface RoleRepository extends JpaRepository<Role, UUID>{
    Role findByName(String name);
}
