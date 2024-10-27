package com.backendproject.springBackend.tiposoportunidad.repository;

import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiposOportunidadRepository extends JpaRepository<TiposOportunidad, Long> {
}
