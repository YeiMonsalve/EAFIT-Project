package com.backendproject.springBackend.instituciones.repository;

import com.backendproject.springBackend.instituciones.model.Instituciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionesRepository extends JpaRepository<Instituciones, Long> {
}