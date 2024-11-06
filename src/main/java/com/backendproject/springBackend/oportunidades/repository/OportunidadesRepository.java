package com.backendproject.springBackend.oportunidades.repository;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OportunidadesRepository extends JpaRepository<Oportunidades, Long> {
}