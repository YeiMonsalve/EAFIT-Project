package com.backendproject.springBackend.estadooportunidad.service;

import com.backendproject.springBackend.estadooportunidad.dto.EstadoOportunidadNoIdDTO;
import com.backendproject.springBackend.estadooportunidad.mapper.EstadoOportunidadMapper;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import com.backendproject.springBackend.estadooportunidad.repository.EstadoOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class EstadoOportunidadService {

    @Autowired
    private EstadoOportunidadRepository estadoOportunidadRepository;

    @Autowired
    private EstadoOportunidadMapper estadoOportunidadMapper;

    //Crear estado oportunidad.
    public EstadoOportunidad crearUnEstadoOportunidad (EstadoOportunidadNoIdDTO estadoOportunidadNoIdDTO) {
       EstadoOportunidad estadoOportunidad = estadoOportunidadMapper.estadoOportunidadSinId(estadoOportunidadNoIdDTO);
       return estadoOportunidadRepository.save(estadoOportunidad);
    }

    //Obtener todos los estados de oportunidades.
    public List<EstadoOportunidad> obtenerEstadoOportunidad() { return estadoOportunidadRepository.findAll(); }

    //Actualizar estados.
    public EstadoOportunidad actualizarEstadoOportunidad(Long id, EstadoOportunidadNoIdDTO estadoDetails) {
        EstadoOportunidad estadoOportunidad = estadoOportunidadRepository.findById(id).orElseThrow();
        estadoOportunidad.setEstado(estadoDetails.getEstado());
        return estadoOportunidadRepository.save(estadoOportunidad);
    }

    //Obtener estado por Id.
    public Optional<EstadoOportunidad> obtenerEstadoOportunidadPorId(Long id) {
        return estadoOportunidadRepository.findById(id);
    }

    //Eliminar un Estado de oportunidades por Id.
    public void eliminarEstadoOportunidad(Long id) { estadoOportunidadRepository.deleteById(id);}

}
