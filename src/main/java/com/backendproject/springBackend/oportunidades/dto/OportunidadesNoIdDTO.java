package com.backendproject.springBackend.oportunidades.dto;

import com.backendproject.springBackend.categoriaoportunidad.dto.CategoriaOportunidadJustIdDTO;
import com.backendproject.springBackend.estadooportunidad.dto.EstadoOportunidadJustIdDTO;
import com.backendproject.springBackend.informacionoportunidad.dto.InformacionOportunidadJustIdDTO;
import com.backendproject.springBackend.tiposoportunidad.dto.TiposOportunidadJustIdDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OportunidadesNoIdDTO {

    private EstadoOportunidadJustIdDTO estadoId;
    private InformacionOportunidadJustIdDTO infoOporId;
    private TiposOportunidadJustIdDTO tiposOporId;
    private CategoriaOportunidadJustIdDTO categoriaOpor;
}