package com.backendproject.springBackend.usuarios.dto;

import com.backendproject.springBackend.roles.dto.RolesJustIdDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuariosNoIdDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private RolesJustIdDTO idRole;
}