package com.backendproject.springBackend.institucionesoportunidades.model;

import com.backendproject.springBackend.instituciones.model.Instituciones;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "instituciones_oportunidades")
@Getter
@Setter
public class InstitucionesOportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "institucion_id", nullable = false)
    private Instituciones institucionId;

    @ManyToOne
    @JoinColumn(name = "oportunidad_id", nullable = false)
    private Oportunidades oportunidadId;
}