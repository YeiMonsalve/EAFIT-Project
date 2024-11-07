package com.backendproject.springBackend.usuarios.mapper;

import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdDTO;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {

    @Mapping(target = "id", ignore = true)
    Usuarios usuariosSinId(UsuariosNoIdDTO usuariosNoIdDTO);
}