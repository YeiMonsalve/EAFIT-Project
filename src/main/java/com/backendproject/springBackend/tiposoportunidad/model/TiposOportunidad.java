package com.backendproject.springBackend.tiposoportunidad.model;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tipos_oportunidad")
@Getter
@Setter
public class TiposOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String url;

    @OneToMany(mappedBy = "tiposOporId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Oportunidades> oportunidades;

    public TiposOportunidad() {
    }

    public TiposOportunidad(Long id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
    }
}