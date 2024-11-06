
package com.backendproject.springBackend.informacionoportunidad.service;

import com.backendproject.springBackend.informacionoportunidad.dto.InformacionOportunidadNoIdDTO;
import com.backendproject.springBackend.informacionoportunidad.mapper.InformacionOportunidadMapper;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.informacionoportunidad.repository.InformacionOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionOportunidadService {

    @Autowired
    private InformacionOportunidadRepository informacionOportunidadRepository;

    @Autowired
    private InformacionOportunidadMapper informacionOportunidadMapper;

    // Crear una información.
    public InformacionOportunidad crearInformacionOportunidad(InformacionOportunidadNoIdDTO informacionOportunidadNoIdDTO) {
        InformacionOportunidad informacionOportunidad = informacionOportunidadMapper.informacionOportunidadSinId(informacionOportunidadNoIdDTO);
        return informacionOportunidadRepository.save(informacionOportunidad);
    }

    //Obtener todas las informaciones.
    public List<InformacionOportunidad> obtenerInformacionOportunidad() {
        return informacionOportunidadRepository.findAll();
    }

    //Actualizar una información.
    public InformacionOportunidad actualizarInformacionOportunidad(Long id, InformacionOportunidadNoIdDTO informacionDetails) {
        InformacionOportunidad informacionOportunidad = informacionOportunidadRepository.findById(id).orElseThrow();
        informacionOportunidad.setInfo(informacionDetails.getInfo());
        return informacionOportunidadRepository.save(informacionOportunidad);
    }

    //Obtener información por Id.
    public Optional<InformacionOportunidad> obtenerInformacionOportunidadPorId(Long id) {
        return informacionOportunidadRepository.findById(id);
    }

    //Eliminar una información por Id.
    public void eliminarInformacionOportunidad(Long id) {
        informacionOportunidadRepository.deleteById(id);



    }

}
