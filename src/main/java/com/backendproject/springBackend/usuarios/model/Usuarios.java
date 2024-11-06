package com.backendproject.springBackend.usuarios.model;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.roles.model.Roles;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Roles idRole;
}
