package com.backendproject.springBackend.estadooportunidad.model;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "estado_oportunidad")
@Getter
@Setter
public class EstadoOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String estado;

    @OneToMany(mappedBy = "estadoId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Oportunidades> oportunidades;
}