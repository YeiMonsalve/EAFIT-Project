package com.backendproject.springBackend.roles.repository;

import com.backendproject.springBackend.roles.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRol(String rol);
}