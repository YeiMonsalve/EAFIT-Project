package com.backendproject.springBackend.instituciones.service;

import com.backendproject.springBackend.instituciones.dto.InstitucionesNoIdDTO;
import com.backendproject.springBackend.instituciones.mapper.InstitucionesMapper;
import com.backendproject.springBackend.instituciones.model.Instituciones;
import com.backendproject.springBackend.instituciones.repository.InstitucionesRepository;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import com.backendproject.springBackend.ubicacionregion.repository.UbicacionRegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstitucionesService {

    @Autowired
    private InstitucionesRepository institucionesRepository;

    @Autowired
    private UbicacionRegionRepository ubicacionRegionRepository;

    @Autowired
    private InstitucionesMapper institucionesMapper;

    // Crear una institución.
    public Instituciones crearUnaInstitucion(InstitucionesNoIdDTO institucionesNoIdDTO) {
        Instituciones instituciones = institucionesMapper.institucionesSinId(institucionesNoIdDTO);
        return institucionesRepository.save(instituciones);
    }

    //Obtener todas las instituciones.
    public List<Instituciones> obtenerInstituciones() {
        return institucionesRepository.findAll();
    }

    //Actualizar una institución.
    public Instituciones actualizarInstitucion(Long id, InstitucionesNoIdDTO institucionDetails) {
        Instituciones instituciones = institucionesRepository.findById(id).orElseThrow();
        instituciones.setNombre(institucionDetails.getNombre());
        instituciones.setDireccion(institucionDetails.getDireccion());

        UbicacionRegion ubicacionRegion = ubicacionRegionRepository.findById((long) institucionDetails.getIdRegion().getId()).orElseThrow();
        instituciones.setIdRegion(ubicacionRegion);

        return institucionesRepository.save(instituciones);
    }

    //Obtener institución por Id.
    public Optional<Instituciones> obtenerInstitucionPorId(Long id) {
        return institucionesRepository.findById(id);
    }

    //Eliminar una institución por Id.
    public void eliminarInstitucion(Long id) {
        institucionesRepository.deleteById(id);
    }
}