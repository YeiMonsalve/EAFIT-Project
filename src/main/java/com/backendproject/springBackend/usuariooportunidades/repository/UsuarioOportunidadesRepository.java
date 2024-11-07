package com.backendproject.springBackend.usuariooportunidades.repository;

import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioOportunidadesRepository extends JpaRepository<UsuarioOportunidades, Long> {
}