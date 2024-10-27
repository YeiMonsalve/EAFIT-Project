
package com.backendproject.springBackend.informacionoportunidad.repository;

import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionOportunidadRepository extends JpaRepository<InformacionOportunidad, Integer> {
}
