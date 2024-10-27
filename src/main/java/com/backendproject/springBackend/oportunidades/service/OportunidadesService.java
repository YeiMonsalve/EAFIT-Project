package com.backendproject.springBackend.oportunidades.service;

import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.categoriaoportunidad.repository.CategoriaOportunidadRepository;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import com.backendproject.springBackend.estadooportunidad.repository.EstadoOportunidadRepository;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.informacionoportunidad.repository.InformacionOportunidadRepository;
import com.backendproject.springBackend.oportunidades.dto.OportunidadesNoIdDTO;
import com.backendproject.springBackend.oportunidades.mapper.OportunidadesMapper;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.oportunidades.repository.OportunidadesRepository;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.repository.TiposOportunidadRepository;
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
        oportunidades.setNombre(oportunidadDetails.getNombre());

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
}