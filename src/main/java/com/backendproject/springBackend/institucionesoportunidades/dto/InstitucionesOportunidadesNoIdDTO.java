package com.backendproject.springBackend.institucionesoportunidades.dto;

import com.backendproject.springBackend.instituciones.dto.InstitucionesJustIdDTO;
import com.backendproject.springBackend.oportunidades.dto.OportunidadesJustIdDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitucionesOportunidadesNoIdDTO {

    private InstitucionesJustIdDTO institucionId;
    private OportunidadesJustIdDTO oportunidadId;
}