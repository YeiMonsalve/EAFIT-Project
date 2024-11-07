package com.backendproject.springBackend.categoriaoportunidad.mapper;

import com.backendproject.springBackend.categoriaoportunidad.dto.CategoriaOportunidadNoIdDTO;
import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaOportunidadMapper {

    @Mapping(target = "id", ignore = true)
    CategoriaOportunidad categoriaOportunidadSinId(CategoriaOportunidadNoIdDTO categoriaOportunidadNoIdDTO);
}