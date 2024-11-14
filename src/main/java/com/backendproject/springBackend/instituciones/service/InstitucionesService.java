package com.backendproject.springBackend.instituciones.service;

import com.backendproject.springBackend.instituciones.dto.InstitucionesNoIdDTO;
import com.backendproject.springBackend.instituciones.mapper.InstitucionesMapper;
import com.backendproject.springBackend.instituciones.model.Instituciones;
import com.backendproject.springBackend.instituciones.repository.InstitucionesRepository;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import com.backendproject.springBackend.ubicacionregion.repository.UbicacionRegionRepository;
import jakarta.annotation.PostConstruct;
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

//    @PostConstruct
//    public void initializeInstituciones() {
//        if (institucionesRepository.findAll().isEmpty()) {
//            UbicacionRegion region1 = ubicacionRegionRepository.findById(1L).orElse(null);
//            UbicacionRegion region2 = ubicacionRegionRepository.findById(2L).orElse(null);
//            UbicacionRegion region3 = ubicacionRegionRepository.findById(3L).orElse(null);
//            UbicacionRegion region4 = ubicacionRegionRepository.findById(4L).orElse(null);
//            UbicacionRegion region5 = ubicacionRegionRepository.findById(5L).orElse(null);
//            UbicacionRegion region6 = ubicacionRegionRepository.findById(6L).orElse(null);
//            UbicacionRegion region7 = ubicacionRegionRepository.findById(7L).orElse(null);
//            UbicacionRegion region8 = ubicacionRegionRepository.findById(8L).orElse(null);
//
//            institucionesRepository.save(new Instituciones(null, "Institución Universitaria de Envigado", "Cra 27 B # 39 A Sur 57", region1));
//            institucionesRepository.save(new Instituciones(null, "Colegio Mayor de Antioquia", "Calle 65#77-126 Robledo", region2));
//            institucionesRepository.save(new Instituciones(null, "ESA Débora Arango", "CALLE 39 SUR 39-8 Envigado", region1));
//            institucionesRepository.save(new Instituciones(null, "Universidad Nacional (sede Medellín)", "Cra. 65 # 59A - 110", region2));
//            institucionesRepository.save(new Instituciones(null, "Universidad EAFIT", "Carrera 49 N° 7 Sur - 50", region3));
//            institucionesRepository.save(new Instituciones(null, "Universidad Católica Luis Amigó", "Transversal 51A #67B 90", region4));
//            institucionesRepository.save(new Instituciones(null, "Universidad Nacional Abierta y a Distancia", "Carrera 45 # 55-19", region5));
//            institucionesRepository.save(new Instituciones(null, "Universidad de Medellín", "Carrera 87 N° 30 – 65", region6));
//            institucionesRepository.save(new Instituciones(null, "Corporación Universitaria Americana", "Calle 50 # 43-65", region7));
//            institucionesRepository.save(new Instituciones(null, "Universidad de Antioquia", "Ciudad Universitaria Calle 57 #53 -108", region8));
//            institucionesRepository.save(new Instituciones(null, "Universidad de Antioquia", "Cra. 51d #62-29", region2));
//        }
//    }

}