package com.backendproject.springBackend.usuarios.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuariosNoIdNoRolDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private Date birthday;
}