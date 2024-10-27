package com.backendproject.springBackend.oportunidades.model;

import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "oportunidades")
@Getter
@Setter
public class Oportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoOportunidad estadoId;

    @ManyToOne
    @JoinColumn(name = "info_id")
    private InformacionOportunidad infoOporId;

    @ManyToOne
    @JoinColumn(name = "tipo_oportunidad_id")
    private TiposOportunidad tiposOporId;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaOportunidad categoriaOpor;
}