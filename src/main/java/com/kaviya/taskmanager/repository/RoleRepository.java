package com.kaviya.taskmanager.repository;

import com.kaviya.taskmanager.entity.Role;
import com.kaviya.taskmanager.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}