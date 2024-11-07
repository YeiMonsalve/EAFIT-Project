package com.backendproject.springBackend.usuariooportunidades.mapper;

import com.backendproject.springBackend.usuariooportunidades.dto.UsuarioOportunidadesNoIdDTO;
import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioOportunidadesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioId.nombre", ignore = true)
    @Mapping(target = "usuarioId.apellido", ignore = true)
    @Mapping(target = "usuarioId.email", ignore = true)
    @Mapping(target = "usuarioId.password", ignore = true)
    @Mapping(target = "usuarioId.birthday", ignore = true)
    @Mapping(target = "usuarioId.idRole", ignore = true)
    @Mapping(target = "oportunidadesId.nombre", ignore = true)
    @Mapping(target = "oportunidadesId.estadoId", ignore = true)
    @Mapping(target = "oportunidadesId.infoOporId", ignore = true)
    @Mapping(target = "oportunidadesId.tiposOporId", ignore = true)
    @Mapping(target = "oportunidadesId.categoriaOpor", ignore = true)
    UsuarioOportunidades usuarioOportunidadesSinId(UsuarioOportunidadesNoIdDTO usuarioOportunidadesNoIdDTO);
}