package com.backendproject.springBackend.instituciones.dto;

import com.backendproject.springBackend.ubicacionregion.dto.UbicacionRegionJustId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitucionesNoIdDTO {

    private String nombre;
    private String direccion;
    private UbicacionRegionJustId idRegion;
}