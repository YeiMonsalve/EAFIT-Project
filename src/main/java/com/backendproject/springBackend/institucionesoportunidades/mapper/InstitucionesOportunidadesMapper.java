package com.backendproject.springBackend.institucionesoportunidades.mapper;

import com.backendproject.springBackend.institucionesoportunidades.dto.InstitucionesOportunidadesNoIdDTO;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstitucionesOportunidadesMapper {

    @Mapping(target = "id", ignore = true)
    InstitucionesOportunidades institucionesOportunidadesSinId(InstitucionesOportunidadesNoIdDTO institucionesOportunidadesNoIdDTO);
}