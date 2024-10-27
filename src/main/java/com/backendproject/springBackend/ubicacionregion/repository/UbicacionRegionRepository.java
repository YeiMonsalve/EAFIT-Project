package com.backendproject.springBackend.ubicacionregion.repository;

import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbicacionRegionRepository extends JpaRepository<UbicacionRegion, Long> {
}
