package com.backendproject.springBackend.usuariooportunidades.model;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_oportunidades")
@Getter
@Setter
public class UsuarioOportunidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuarios usuarioId;

    @ManyToOne
    @JoinColumn(name = "oportunidades_id", nullable = false)
    private Oportunidades oportunidadesId;
}