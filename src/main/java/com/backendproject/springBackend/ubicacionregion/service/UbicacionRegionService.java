package com.backendproject.springBackend.ubicacionregion.service;

import com.backendproject.springBackend.ubicacionregion.dto.UbicacionRegionNoIdDTO;
import com.backendproject.springBackend.ubicacionregion.mapper.UbicacionRegionMapper;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import com.backendproject.springBackend.ubicacionregion.repository.UbicacionRegionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UbicacionRegionService {

    @Autowired
    private UbicacionRegionRepository ubicacionRegionRepository;

    @Autowired
    private UbicacionRegionMapper ubicacionRegionMapper;

    // Crear una ubicación.
    public UbicacionRegion crearUnaUbicacionRegion(UbicacionRegionNoIdDTO ubicacionRegionNoIdDTO) {
        UbicacionRegion ubicacionRegion = ubicacionRegionMapper.ubicacionRegionSinId(ubicacionRegionNoIdDTO);
        return ubicacionRegionRepository.save(ubicacionRegion);
    }

    //Obtener todas las ubicaciones.
    public List<UbicacionRegion> obtenerUbicacionesRegion() {
        return ubicacionRegionRepository.findAll();
    }

    //Actualizar una ubicación.
    public UbicacionRegion actualizarUbicacionRegion(Long id, UbicacionRegionNoIdDTO ubicacionDetails) {
        UbicacionRegion ubicacionRegion = ubicacionRegionRepository.findById(id).orElseThrow();
        ubicacionRegion.setRegion(ubicacionDetails.getRegion());
        return ubicacionRegionRepository.save(ubicacionRegion);
    }

    //Obtener ubicación por Id.
    public Optional<UbicacionRegion> obtenerUbicacionRegionPorId(Long id) {
        return ubicacionRegionRepository.findById(id);
    }

    //Eliminar una Ubicación por Id.
    public void eliminarUbicacionRegion(Long id) {
        ubicacionRegionRepository.deleteById(id);
    }

    @PostConstruct
    public void initializeRoles() {
        if (ubicacionRegionRepository.findAll().isEmpty()) {
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Sur"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Noroccidental"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Suroriental"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Centro Occidental"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Centro Oriental"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Suroccidental"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Centro"));
            ubicacionRegionRepository.save(new UbicacionRegion(null, "Nororiente"));
        }
    }
}