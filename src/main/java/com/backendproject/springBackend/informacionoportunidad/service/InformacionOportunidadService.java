
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

    // Crear una información de oportunidad.
    public InformacionOportunidad crearInformacionOportunidad(InformacionOportunidadNoIdDTO informacionOportunidadNoIdDTO) {
        InformacionOportunidad informacionOportunidad = informacionOportunidadMapper.toEntity(informacionOportunidadNoIdDTO);
        return informacionOportunidadRepository.save(informacionOportunidad);
    }

    //Obtener toda la información de oportunidades.
    public List<InformacionOportunidad> obtenerInformacionOportunidades() {
        return informacionOportunidadRepository.findAll();
    }

    //Actualizar una información de oportunidad.
    public InformacionOportunidad actualizarInformacionOportunidad(int id, InformacionOportunidadNoIdDTO informacionDetails) {
        InformacionOportunidad informacionOportunidad = informacionOportunidadRepository.findById(id).orElseThrow();
        informacionOportunidad.setInfo(informacionDetails.getInfo());
        return informacionOportunidadRepository.save(informacionOportunidad);
    }

    //Obtener información por Id.
    public Optional<InformacionOportunidad> obtenerInformacionOportunidadPorId(int id) {
        return informacionOportunidadRepository.findById(id);
    }

    //Eliminar una información de oportunidad por Id.
    public void eliminarInformacionOportunidad(int id) {
        informacionOportunidadRepository.deleteById(id);



    }

}
