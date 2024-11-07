package com.backendproject.springBackend.tiposoportunidad.service;

import com.backendproject.springBackend.tiposoportunidad.dto.TiposOportunidadNoIdDTO;
import com.backendproject.springBackend.tiposoportunidad.mapper.TiposOportunidadMapper;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.repository.TiposOportunidadRepository;
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
        tiposOportunidad.setDescripcion(tipoOportunidadDetails.getDescripcion());
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
}
