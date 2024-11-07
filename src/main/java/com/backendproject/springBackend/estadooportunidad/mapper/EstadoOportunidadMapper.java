package com.backendproject.springBackend.estadooportunidad.mapper;

import com.backendproject.springBackend.estadooportunidad.dto.EstadoOportunidadJustIdDTO;
import com.backendproject.springBackend.estadooportunidad.dto.EstadoOportunidadNoIdDTO;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EstadoOportunidadMapper {

    @Mapping(target = "id", ignore = true)
    EstadoOportunidad estadoOportunidadSinId(EstadoOportunidadNoIdDTO estadoOportunidadNoIdDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "estado", ignore = true)
    EstadoOportunidad toEntity(EstadoOportunidadJustIdDTO estadoOportunidadJustIdDTO);
}