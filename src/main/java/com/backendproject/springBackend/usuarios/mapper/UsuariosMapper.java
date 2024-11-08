package com.backendproject.springBackend.usuarios.mapper;

import com.backendproject.springBackend.roles.mapper.RolesMapper;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdDTO;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdNoRolDTO;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RolesMapper.class})
public interface UsuariosMapper {

    @Mapping(target = "id", ignore = true)
    Usuarios usuariosSinId(UsuariosNoIdDTO usuariosNoIdDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idRole", ignore = true)
    Usuarios usuariosNoIdNoRol(UsuariosNoIdNoRolDTO usuariosNoIdNoRolDTO);
}