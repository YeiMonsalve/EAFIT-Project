package com.backendproject.springBackend.usuarios.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLoginDTO {

    private String email;
    private String password;
}
