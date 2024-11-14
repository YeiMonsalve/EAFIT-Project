package com.backendproject.springBackend.tiposoportunidad.service;

import com.backendproject.springBackend.tiposoportunidad.dto.TiposOportunidadNoIdDTO;
import com.backendproject.springBackend.tiposoportunidad.mapper.TiposOportunidadMapper;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.repository.TiposOportunidadRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiposOportunidadService {

    @Autowired
    private TiposOportunidadRepository tiposOportunidadRepository;

    @Autowired
    private TiposOportunidadMapper tiposOportunidadMapper;

    // Crear un tipo de oportunidad.
    public TiposOportunidad crearUnTipoInformacion(TiposOportunidadNoIdDTO tiposOportunidadNoIdDTO) {
        TiposOportunidad tiposOportunidad = tiposOportunidadMapper.tiposOportunidadSinId(tiposOportunidadNoIdDTO);
        return tiposOportunidadRepository.save(tiposOportunidad);
    }

    //Obtener todos los tipos de oportunidad.
    public List<TiposOportunidad> obtenerTiposOportunidad() {
        return tiposOportunidadRepository.findAll();
    }

    //Actualizar un tipo de oportunidad.
    public TiposOportunidad actualizarTiposOportunidad(Long id, TiposOportunidadNoIdDTO tipoOportunidadDetails) {
        TiposOportunidad tiposOportunidad = tiposOportunidadRepository.findById(id).orElseThrow();
        tiposOportunidad.setNombre(tipoOportunidadDetails.getNombre());
        tiposOportunidad.setUrl(tipoOportunidadDetails.getUrl());
        return tiposOportunidadRepository.save(tiposOportunidad);
    }

    //Obtener tipo de oportunidad por Id.
    public Optional<TiposOportunidad> obtenerTiposOportunidadPorId(Long id) {
        return tiposOportunidadRepository.findById(id);
    }

    //Eliminar un tipo de oportunidad por Id.
    public void eliminarTiposOportunidad(Long id) {
        tiposOportunidadRepository.deleteById(id);
    }

    @PostConstruct
    public void initializeTiposOportunidad() {
        if (tiposOportunidadRepository.findAll().isEmpty()) {
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Cursos Virtuales SENA", "https://www.sena.edu.co/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Arroba Medellín", "https://arrobamedellin.edu.co/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Cursos Comfama", "https://www.comfama.com/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Floqq", "https://www.floqq.com/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Beca del municipio de Itagüí", "https://www.semitagui.gov.co/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Matrícula Cero Distrito de Medellín", "https://sapiencia.gov.co/matricula-cero/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Jóvenes en acción", "https://prosperidadsocial.gov.co/sgpp/transferencias/jovenes-en-accion/inscripciones/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Fondo Sapiencia EPM - Universidades", "https://sapiencia.gov.co/fondos-sapiencia/epm-y-universidades/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Sena", "https://sena.edu.co/es-co/formacion/media/forms/allitems.aspx?rootfolder=/es-co/formacion/media/bootcamps&folderctid=0x0120d520a808007402f768f739d245b5d314d3c165801e"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Nodo Eafit", "https://es.nodoeafit.com/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "Open Bootcamp", "https://open-bootcamp.com/"));
            tiposOportunidadRepository.save(new TiposOportunidad(null, "MinTic", "https://cursoscortossenatec.co/"));
        }
    }
}