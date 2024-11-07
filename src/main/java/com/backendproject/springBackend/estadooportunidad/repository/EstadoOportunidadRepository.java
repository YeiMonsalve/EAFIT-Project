package com.backendproject.springBackend.estadooportunidad.repository;

import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoOportunidadRepository extends JpaRepository<EstadoOportunidad, Long> {
}