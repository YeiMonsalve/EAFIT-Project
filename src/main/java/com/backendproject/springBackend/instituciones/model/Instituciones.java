package com.backendproject.springBackend.instituciones.model;

import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instituciones")
@Getter @Setter
public class Instituciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String direccion;

    @ManyToOne
    @JoinColumn(name = "id_region")
    private UbicacionRegion idRegion;

}