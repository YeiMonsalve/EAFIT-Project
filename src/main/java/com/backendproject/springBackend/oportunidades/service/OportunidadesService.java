package com.backendproject.springBackend.oportunidades.service;

import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.categoriaoportunidad.repository.CategoriaOportunidadRepository;
import com.backendproject.springBackend.categoriaoportunidad.service.CategoriaOportunidadService;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import com.backendproject.springBackend.estadooportunidad.repository.EstadoOportunidadRepository;
import com.backendproject.springBackend.estadooportunidad.service.EstadoOportunidadService;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.informacionoportunidad.repository.InformacionOportunidadRepository;
import com.backendproject.springBackend.informacionoportunidad.service.InformacionOportunidadService;
import com.backendproject.springBackend.oportunidades.dto.OportunidadesNoIdDTO;
import com.backendproject.springBackend.oportunidades.mapper.OportunidadesMapper;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.oportunidades.repository.OportunidadesRepository;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.repository.TiposOportunidadRepository;
import com.backendproject.springBackend.tiposoportunidad.service.TiposOportunidadService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadesService {

    @Autowired
    private OportunidadesRepository oportunidadesRepository;

    @Autowired
    private CategoriaOportunidadRepository categoriaOportunidadRepository;

    @Autowired
    private EstadoOportunidadRepository estadoOportunidadRepository;

    @Autowired
    private InformacionOportunidadRepository informacionOportunidadRepository;

    @Autowired
    private TiposOportunidadRepository tiposOportunidadRepository;

    @Autowired
    private OportunidadesMapper oportunidadesMapper;

    @Autowired
    private EstadoOportunidadService estadoOportunidadService;

    @Autowired
    private TiposOportunidadService tiposOportunidadService;

    @Autowired
    private CategoriaOportunidadService categoriaOportunidadService;

    @Autowired
    private InformacionOportunidadService informacionOportunidadService;

    // Crear una oportunidad.
    public Oportunidades crearUnaOportunidad(OportunidadesNoIdDTO oportunidadesNoIdDTO) {
        Oportunidades oportunidades = oportunidadesMapper.oportunidadesSinId(oportunidadesNoIdDTO);
        return oportunidadesRepository.save(oportunidades);
    }

    //Obtener todas las oportunidades.
    public List<Oportunidades> obtenerOportunidades() {
        return oportunidadesRepository.findAll();
    }

    //Actualizar una oportunidad.
    public Oportunidades actualizarOportunidad(Long id, OportunidadesNoIdDTO oportunidadDetails) {
        Oportunidades oportunidades = oportunidadesRepository.findById(id).orElseThrow();

        CategoriaOportunidad categoriaOportunidad = categoriaOportunidadRepository.findById((long) oportunidadDetails.getCategoriaOpor().getId()).orElseThrow();
        oportunidades.setCategoriaOpor(categoriaOportunidad);

        EstadoOportunidad estadoOportunidad = estadoOportunidadRepository.findById((long) oportunidadDetails.getEstadoId().getId()).orElseThrow();
        oportunidades.setEstadoId(estadoOportunidad);

        InformacionOportunidad informacionOportunidad = informacionOportunidadRepository.findById((long) oportunidadDetails.getInfoOporId().getId()).orElseThrow();
        oportunidades.setInfoOporId(informacionOportunidad);

        TiposOportunidad tiposOportunidad = tiposOportunidadRepository.findById((long) oportunidadDetails.getTiposOporId().getId()).orElseThrow();
        oportunidades.setTiposOporId(tiposOportunidad);

        return oportunidadesRepository.save(oportunidades);
    }

    //Obtener oportunidad por Id.
    public Optional<Oportunidades> obtenerOportunidadPorId(Long id) {
        return oportunidadesRepository.findById(id);
    }

    //Eliminar una oportunidad por Id.
    public void eliminarOportunidad(Long id) {
        oportunidadesRepository.deleteById(id);
    }

    @PostConstruct
    public void initializeOportunidades() {

        estadoOportunidadService.initializeEstado();
        informacionOportunidadService.initializeInformacion();
        tiposOportunidadService.initializeTiposOportunidad();
        categoriaOportunidadService.initializeCategoria();

        if (oportunidadesRepository.findAll().isEmpty()) {

            EstadoOportunidad estado1 = estadoOportunidadRepository.findById(1L).orElse(null);
            EstadoOportunidad estado2 = estadoOportunidadRepository.findById(2L).orElse(null);

            InformacionOportunidad info1 = informacionOportunidadRepository.findById(1L).orElse(null);
            InformacionOportunidad info2 = informacionOportunidadRepository.findById(2L).orElse(null);
            InformacionOportunidad info3 = informacionOportunidadRepository.findById(3L).orElse(null);

            TiposOportunidad tipo1 = tiposOportunidadRepository.findById(1L).orElse(null);
            TiposOportunidad tipo2 = tiposOportunidadRepository.findById(2L).orElse(null);
            TiposOportunidad tipo3 = tiposOportunidadRepository.findById(3L).orElse(null);
            TiposOportunidad tipo4 = tiposOportunidadRepository.findById(4L).orElse(null);
            TiposOportunidad tipo5 = tiposOportunidadRepository.findById(5L).orElse(null);
            TiposOportunidad tipo6 = tiposOportunidadRepository.findById(6L).orElse(null);
            TiposOportunidad tipo7 = tiposOportunidadRepository.findById(7L).orElse(null);
            TiposOportunidad tipo8 = tiposOportunidadRepository.findById(8L).orElse(null);
            TiposOportunidad tipo9 = tiposOportunidadRepository.findById(9L).orElse(null);
            TiposOportunidad tipo10 = tiposOportunidadRepository.findById(10L).orElse(null);
            TiposOportunidad tipo11 = tiposOportunidadRepository.findById(11L).orElse(null);
            TiposOportunidad tipo12 = tiposOportunidadRepository.findById(12L).orElse(null);

            CategoriaOportunidad cat1 = categoriaOportunidadRepository.findById(1L).orElse(null);
            CategoriaOportunidad cat2 = categoriaOportunidadRepository.findById(2L).orElse(null);
            CategoriaOportunidad cat3 = categoriaOportunidadRepository.findById(3L).orElse(null);

            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo1, cat1));
            oportunidadesRepository.save(new Oportunidades(null, estado2, info3, tipo5, cat2));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo11, cat3));
            oportunidadesRepository.save(new Oportunidades(null, estado2, info1, tipo6, cat2));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo4, cat1));
            oportunidadesRepository.save(new Oportunidades(null, estado2, info2, tipo7, cat2));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo3, cat1));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo9, cat3));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo8, cat2));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo10, cat3));
            oportunidadesRepository.save(new Oportunidades(null, estado2, info2, tipo2, cat1));
            oportunidadesRepository.save(new Oportunidades(null, estado1, info1, tipo12, cat3));
        }
    }
}