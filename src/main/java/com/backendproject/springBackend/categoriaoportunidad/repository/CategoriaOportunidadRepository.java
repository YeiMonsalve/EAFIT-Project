package com.backendproject.springBackend.categoriaoportunidad.repository;

import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaOportunidadRepository extends JpaRepository<CategoriaOportunidad, Long> {
}
