package com.backendproject.springBackend.institucionesoportunidades.repository;

import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstitucionesOportunidadesRepository extends JpaRepository<InstitucionesOportunidades, Long>{
}