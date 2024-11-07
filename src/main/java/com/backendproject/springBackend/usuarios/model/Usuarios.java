package com.backendproject.springBackend.usuarios.model;

import com.backendproject.springBackend.roles.model.Roles;
import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
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
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Roles idRole;

    @OneToMany(mappedBy = "usuarioId", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<UsuarioOportunidades> usuarioOportunidades;
}