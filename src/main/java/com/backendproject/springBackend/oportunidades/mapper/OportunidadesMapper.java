package com.backendproject.springBackend.oportunidades.mapper;

import com.backendproject.springBackend.estadooportunidad.mapper.EstadoOportunidadMapper;
import com.backendproject.springBackend.oportunidades.dto.OportunidadesNoIdDTO;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {EstadoOportunidadMapper.class})
public interface OportunidadesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "infoOporId.info", ignore = true)
    @Mapping(target = "tiposOporId.nombre", ignore = true)
    @Mapping(target = "tiposOporId.descripcion", ignore = true)
    @Mapping(target = "categoriaOpor", ignore = true)
    Oportunidades oportunidadesSinId(OportunidadesNoIdDTO oportunidadesNoIdDTO);
}