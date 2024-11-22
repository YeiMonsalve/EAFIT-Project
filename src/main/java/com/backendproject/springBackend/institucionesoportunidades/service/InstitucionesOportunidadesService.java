package com.backendproject.springBackend.institucionesoportunidades.service;

import com.backendproject.springBackend.instituciones.model.Instituciones;
import com.backendproject.springBackend.instituciones.repository.InstitucionesRepository;
import com.backendproject.springBackend.instituciones.service.InstitucionesService;
import com.backendproject.springBackend.institucionesoportunidades.dto.FiltrarOportunidadesDTO;
import com.backendproject.springBackend.institucionesoportunidades.dto.InstitucionesOportunidadesNoIdDTO;
import com.backendproject.springBackend.institucionesoportunidades.mapper.InstitucionesOportunidadesMapper;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import com.backendproject.springBackend.institucionesoportunidades.repository.CustomInstitucionesOportunidadesRepositoryImpl;
import com.backendproject.springBackend.institucionesoportunidades.repository.InstitucionesOportunidadesRepository;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.oportunidades.repository.OportunidadesRepository;
import com.backendproject.springBackend.oportunidades.service.OportunidadesService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InstitucionesOportunidadesService {

    @Autowired
    private InstitucionesOportunidadesRepository institucionesOportunidadesRepository;

    @Autowired
    private InstitucionesOportunidadesMapper institucionesOportunidadesMapper;

    @Autowired
    private InstitucionesRepository institucionesRepository;

    @Autowired
    private OportunidadesRepository oportunidadesRepository;

    @Autowired
    private OportunidadesService oportunidadesService;

    @Autowired
    private InstitucionesService institucionesService;

    @Autowired
    private CustomInstitucionesOportunidadesRepositoryImpl customInstitucionesOportunidadesRepository;

    // Crear una relación institución-oportunidad.
    public InstitucionesOportunidades crearUnaInstitucionOportunidad(InstitucionesOportunidadesNoIdDTO institucionesOportunidadesNoIdDTO) {
        InstitucionesOportunidades institucionesOportunidades = institucionesOportunidadesMapper.institucionesOportunidadesSinId(institucionesOportunidadesNoIdDTO);
        return institucionesOportunidadesRepository.save(institucionesOportunidades);
    }

    //Obtener todas las relaciones institución-oportunidad.
    public List<InstitucionesOportunidades> obtenerInstitucionesOportunidades() {
        return institucionesOportunidadesRepository.findAll();
    }

    //Obtener todas las relaciones institución-oportunidad.
    public List<FiltrarOportunidadesDTO> filtrador() {

        List<InstitucionesOportunidades> institucionesOportunidadesList = institucionesOportunidadesRepository.findAll();

        List<FiltrarOportunidadesDTO> filtrarOportunidadesDTOList = mapperToDTO(institucionesOportunidadesList);

        return filtrarOportunidadesDTOList;
    }

    private static List<FiltrarOportunidadesDTO> mapperToDTO(List<InstitucionesOportunidades> institucionesOportunidadesList) {
        List<FiltrarOportunidadesDTO> filtrarOportunidadesDTOList = institucionesOportunidadesList.stream()
                .map(oportunidad -> new FiltrarOportunidadesDTO(oportunidad.getOportunidadId().getTiposOporId().getNombre(), oportunidad.getInstitucionId().getIdRegion().getId(), oportunidad.getOportunidadId().getCategoriaOpor().getId(), oportunidad.getInstitucionId().getId(), oportunidad.getInstitucionId().getIdRegion().getRegion(), oportunidad.getOportunidadId().getTiposOporId().getNombre(), oportunidad.getInstitucionId().getNombre(), oportunidad.getOportunidadId().getTiposOporId().getUrl())).collect(Collectors.toList());
        return filtrarOportunidadesDTOList;
    }

    //Actualizar una relación institución-oportunidad.
    public InstitucionesOportunidades actualizarInstitucionOportunidad(Long id, InstitucionesOportunidadesNoIdDTO institucionOportunidadDetails) {

        InstitucionesOportunidades institucionesOportunidades = institucionesOportunidadesRepository.findById(id).orElseThrow();

        Instituciones instituciones = institucionesRepository.findById((long) institucionOportunidadDetails.getInstitucionId().getId()).orElseThrow();
        institucionesOportunidades.setInstitucionId(instituciones);

        Oportunidades oportunidades = oportunidadesRepository.findById((long) institucionOportunidadDetails.getOportunidadId().getId()).orElseThrow();
        institucionesOportunidades.setOportunidadId(oportunidades);

        return institucionesOportunidadesRepository.save(institucionesOportunidades);
    }

    //Obtener institución-oportunidad por Id.
    public Optional<InstitucionesOportunidades> obtenerInstitucionOportunidadPorId(Long id) {
        return institucionesOportunidadesRepository.findById(id);
    }

    //Eliminar una institución-oportunidad por Id.
    public void eliminarInstitucionOportunidad(Long id) {
        institucionesOportunidadesRepository.deleteById(id);
    }

    //Filtrar oportunidades.
    public List<FiltrarOportunidadesDTO> filtrador(FiltrarOportunidadesDTO filtrarOportunidadesDTO) {

        List<InstitucionesOportunidades> institucionesOportunidadesList = customInstitucionesOportunidadesRepository.filtrarOportunidades(filtrarOportunidadesDTO);

        List<FiltrarOportunidadesDTO> filtrarOportunidadesDTOList = mapperToDTO(institucionesOportunidadesList);

        return filtrarOportunidadesDTOList;
    }

    @PostConstruct
    public void initializeInstitucionOportunidad() {

        oportunidadesService.initializeOportunidades();
        institucionesService.initializeInstituciones();

        if (institucionesOportunidadesRepository.findAll().isEmpty()) {

            Instituciones institucion1 = institucionesRepository.findById(1L).orElse(null);
            Instituciones institucion2 = institucionesRepository.findById(2L).orElse(null);
            Instituciones institucion3 = institucionesRepository.findById(3L).orElse(null);
            Instituciones institucion4 = institucionesRepository.findById(4L).orElse(null);

            Oportunidades oportunidad2 = oportunidadesRepository.findById(2L).orElse(null);
            Oportunidades oportunidad11 = oportunidadesRepository.findById(11L).orElse(null);
            Oportunidades oportunidad4 = oportunidadesRepository.findById(4L).orElse(null);
            Oportunidades oportunidad6 = oportunidadesRepository.findById(6L).orElse(null);

            // Crea las relaciones en la tabla intermedia
            institucionesOportunidadesRepository.save(new InstitucionesOportunidades(null, institucion1, oportunidad2));
            institucionesOportunidadesRepository.save(new InstitucionesOportunidades(null, institucion2, oportunidad11));
            institucionesOportunidadesRepository.save(new InstitucionesOportunidades(null, institucion2, oportunidad4));
            institucionesOportunidadesRepository.save(new InstitucionesOportunidades(null, institucion2, oportunidad6));
            institucionesOportunidadesRepository.save(new InstitucionesOportunidades(null, institucion3, oportunidad6));
            institucionesOportunidadesRepository.save(new InstitucionesOportunidades(null, institucion4, oportunidad6));
        }
    }
}