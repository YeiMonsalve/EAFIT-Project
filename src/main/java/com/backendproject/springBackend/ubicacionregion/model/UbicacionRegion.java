package com.backendproject.springBackend.ubicacionregion.model;

import com.backendproject.springBackend.instituciones.model.Instituciones;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ubicacion_region")
@Getter
@Setter
public class UbicacionRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String region;

    @OneToMany(mappedBy = "idRegion", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Instituciones> instituciones;
}