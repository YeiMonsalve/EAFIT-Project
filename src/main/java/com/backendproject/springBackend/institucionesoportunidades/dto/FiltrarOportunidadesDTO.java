package com.backendproject.springBackend.institucionesoportunidades.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FiltrarOportunidadesDTO {

    private String nombre;
    private Long idRegion;
    private Long idCategoria;
    private Long idInstitucion;
    private String regionNombre;
    private String categoriaNombre;
    private String institucionNombre;
    private String url;

    public FiltrarOportunidadesDTO(String nombre, Long idRegion, Long idCategoria, Long idInstitucion, String regionNombre, String categoriaNombre, String institucionNombre, String url) {
        this.nombre = nombre;
        this.idRegion = idRegion;
        this.idCategoria = idCategoria;
        this.idInstitucion = idInstitucion;
        this.regionNombre = regionNombre;
        this.categoriaNombre = categoriaNombre;
        this.institucionNombre = institucionNombre;
        this.url = url;
    }
}
