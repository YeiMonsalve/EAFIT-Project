package com.backendproject.springBackend.usuarios.service;

import com.backendproject.springBackend.roles.model.Roles;
import com.backendproject.springBackend.roles.repository.RolesRepository;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdDTO;
import com.backendproject.springBackend.usuarios.mapper.UsuariosMapper;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import com.backendproject.springBackend.usuarios.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosMapper usuariosMapper;

    @Autowired
    private RolesRepository rolesRepository;

    // Crear un Usuario.
    public Usuarios crearUnUsuario(UsuariosNoIdDTO usuariosNoIdDTO) {
        Usuarios usuarios = usuariosMapper.usuariosSinId(usuariosNoIdDTO);
        return usuariosRepository.save(usuarios);
    }

    //Obtener todos los usuarios.
    public List<Usuarios> obtenerUsuarios() {
        return usuariosRepository.findAll();
    }

    //Actualizar un usuario.
    public Usuarios actualizarUsuarios(Long id, UsuariosNoIdDTO usuariosDetails) {
        Usuarios usuarios = usuariosRepository.findById(id).orElseThrow();
        usuarios.setNombre(usuariosDetails.getNombre());
        usuarios.setApellido(usuariosDetails.getApellido());
        usuarios.setUsername(usuariosDetails.getUsername());
        usuarios.setPassword(usuariosDetails.getPassword());

        Roles roles = rolesRepository.findById((long) usuariosDetails.getIdRole().getId()).orElseThrow();
        usuarios.setIdRole(roles);

        return usuariosRepository.save(usuarios);
    }

    //Obtener usuario por Id.
    public Optional<Usuarios> obtenerUsuariosPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    //Eliminar un usuario por Id.
    public void eliminarUsuarios(Long id) {
        usuariosRepository.deleteById(id);
    }
}