package com.backendproject.springBackend.informacionoportunidad.model;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "informacion_oportunidad")
@Getter
@Setter
public class InformacionOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String info;

    @OneToMany(mappedBy = "infoOporId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Oportunidades> oportunidades;
}