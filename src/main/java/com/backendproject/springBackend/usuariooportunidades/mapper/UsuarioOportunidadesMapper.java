package com.backendproject.springBackend.usuariooportunidades.mapper;

import com.backendproject.springBackend.usuariooportunidades.dto.UsuarioOportunidadesNoIdDTO;
import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioOportunidadesMapper {

    @Mapping(target = "id", ignore = true)
    UsuarioOportunidades usuarioOportunidadesSinId(UsuarioOportunidadesNoIdDTO usuarioOportunidadesNoIdDTO);
}