package com.backendproject.springBackend.tiposoportunidad.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipos_oportunidad")
@Getter
@Setter
public class TiposOportunidad {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String nombre;
  private String descripcion;

}