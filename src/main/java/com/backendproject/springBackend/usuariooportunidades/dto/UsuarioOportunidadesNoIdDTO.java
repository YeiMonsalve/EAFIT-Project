package com.backendproject.springBackend.usuariooportunidades.dto;

import com.backendproject.springBackend.oportunidades.dto.OportunidadesJustIdDTO;
import com.backendproject.springBackend.usuarios.dto.UsuariosJustIdDTO;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioOportunidadesNoIdDTO {

    private UsuariosJustIdDTO usuarioId;
    private OportunidadesJustIdDTO oportunidadesId;
}