package com.backendproject.springBackend.informacionoportunidad.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "informacion_oportunidad")
@Getter
@Setter
public class InformacionOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String info;

}