package com.backendproject.springBackend.institucionesoportunidades.dto;

import com.backendproject.springBackend.instituciones.dto.InstitucionesJustIdDto;
import com.backendproject.springBackend.oportunidades.dto.OportunidadesJustIdDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitucionesOportunidadesNoIdDTO {

    private InstitucionesJustIdDto institucionId;
    private OportunidadesJustIdDTO oportunidadId;
}