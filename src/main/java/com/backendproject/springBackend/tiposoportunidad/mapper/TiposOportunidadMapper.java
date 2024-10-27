package com.backendproject.springBackend.tiposoportunidad.mapper;

import com.backendproject.springBackend.tiposoportunidad.dto.TiposOportunidadNoIdDTO;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TiposOportunidadMapper {

  @Mapping(target = "id", ignore = true)
  TiposOportunidad tiposOportunidadSinId(TiposOportunidadNoIdDTO tiposOportunidadNoIdDTO);
}
