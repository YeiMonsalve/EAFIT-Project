package com.backendproject.springBackend.institucionesoportunidades.repository;

import com.backendproject.springBackend.institucionesoportunidades.dto.FiltrarOportunidadesDTO;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;

import java.util.List;

public interface CustomInstitucionesOportunidadesRepository {
    List<InstitucionesOportunidades> filtrarOportunidades(FiltrarOportunidadesDTO filtrarOportunidadesDTO);
}
