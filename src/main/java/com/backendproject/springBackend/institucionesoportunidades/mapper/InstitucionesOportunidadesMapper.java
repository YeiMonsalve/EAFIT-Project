package com.backendproject.springBackend.institucionesoportunidades.mapper;

import com.backendproject.springBackend.institucionesoportunidades.dto.InstitucionesOportunidadesNoIdDTO;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstitucionesOportunidadesMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "institucionId.nombre", ignore = true)
    @Mapping(target = "institucionId.direccion", ignore = true)
    @Mapping(target = "institucionId.idRegion", ignore = true)
    @Mapping(target = "oportunidadId.estadoId", ignore = true)
    @Mapping(target = "oportunidadId.infoOporId", ignore = true)
    @Mapping(target = "oportunidadId.tiposOporId", ignore = true)
    @Mapping(target = "oportunidadId.categoriaOpor", ignore = true)
    InstitucionesOportunidades institucionesOportunidadesSinId(InstitucionesOportunidadesNoIdDTO institucionesOportunidadesNoIdDTO);
}