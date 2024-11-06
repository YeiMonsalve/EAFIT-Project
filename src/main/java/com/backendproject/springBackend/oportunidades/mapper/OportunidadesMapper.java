package com.backendproject.springBackend.oportunidades.mapper;

import com.backendproject.springBackend.oportunidades.dto.OportunidadesNoIdDTO;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OportunidadesMapper {

    @Mapping(target = "id", ignore = true)
    Oportunidades oportunidadesSinId(OportunidadesNoIdDTO oportunidadesNoIdDTO);
}