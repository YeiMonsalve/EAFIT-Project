package com.backendproject.springBackend.ubicacionregion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ubicacion_region")
@Getter
@Setter
public class UbicacionRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String region;
}