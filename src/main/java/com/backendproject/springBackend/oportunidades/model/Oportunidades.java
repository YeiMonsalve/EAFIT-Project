package com.backendproject.springBackend.oportunidades.model;

import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "oportunidades")
@Getter
@Setter
public class Oportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private EstadoOportunidad estadoId;

    @ManyToOne
    @JoinColumn(name = "info_id", nullable = false)
    private InformacionOportunidad infoOporId;

    @ManyToOne
    @JoinColumn(name = "tipo_oportunidad_id", nullable = false)
    private TiposOportunidad tiposOporId;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaOportunidad categoriaOpor;

    @OneToMany(mappedBy = "oportunidadId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<InstitucionesOportunidades> oportunidadesInstituciones;

    @OneToMany(mappedBy = "oportunidadesId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<UsuarioOportunidades> usuarioOportunidades;
}