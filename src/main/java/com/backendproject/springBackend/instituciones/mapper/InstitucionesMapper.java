package com.backendproject.springBackend.instituciones.mapper;

import com.backendproject.springBackend.instituciones.dto.InstitucionesNoIdDTO;
import com.backendproject.springBackend.instituciones.model.Instituciones;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstitucionesMapper {

    @Mapping(target = "id", ignore = true)
    Instituciones institucionesSinId(InstitucionesNoIdDTO institucionesNoIdDTO);
}