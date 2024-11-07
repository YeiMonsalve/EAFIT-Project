package com.backendproject.springBackend.usuarios.repository;

import com.backendproject.springBackend.usuarios.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
}