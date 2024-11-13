package com.backendproject.springBackend.roles.model;

import com.backendproject.springBackend.usuarios.model.Usuarios;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rol;

    @OneToMany(mappedBy = "idRole", cascade = CascadeType.REMOVE)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    private List<Usuarios> usuarios;

    public Roles() {
    }

    public Roles(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }
}