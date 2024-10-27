package com.backendproject.springBackend.informacionoportunidad.mapper;

import com.backendproject.springBackend.informacionoportunidad.dto.InformacionOportunidadNoIdDTO;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InformacionOportunidadMapper {

    @Mapping(target = "id", ignore = true)
    InformacionOportunidad informacionOportunidadSinId(InformacionOportunidadNoIdDTO informacionOportunidadNoIdDTO);
}