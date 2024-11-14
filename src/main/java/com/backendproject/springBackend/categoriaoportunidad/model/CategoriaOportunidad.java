package com.backendproject.springBackend.categoriaoportunidad.model;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categoria_oportunidad")
@Getter
@Setter
public class CategoriaOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "categoriaOpor", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Oportunidades> oportunidades;

    public CategoriaOportunidad() {
    }

    public CategoriaOportunidad(Long id, String categoria) {
        this.id = id;
        this.categoria = categoria;
    }
}