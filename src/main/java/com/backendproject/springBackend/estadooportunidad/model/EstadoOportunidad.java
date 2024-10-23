package com.backendproject.springBackend.estadooportunidad.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estado_oportunidad")
@Getter
@Setter
public class EstadoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;
}
