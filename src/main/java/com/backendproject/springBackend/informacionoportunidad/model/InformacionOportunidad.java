package com.backendproject.springBackend.informacionoportunidad.model;

import jakarta.persistence.*;

@Entity
@Table(name = "informacion_oportunidad")
public class InformacionOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String info;

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
