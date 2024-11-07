package com.backendproject.springBackend.usuariooportunidades.service;

import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.oportunidades.repository.OportunidadesRepository;
import com.backendproject.springBackend.usuariooportunidades.dto.UsuarioOportunidadesNoIdDTO;
import com.backendproject.springBackend.usuariooportunidades.mapper.UsuarioOportunidadesMapper;
import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
import com.backendproject.springBackend.usuariooportunidades.repository.UsuarioOportunidadesRepository;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import com.backendproject.springBackend.usuarios.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioOportunidadesService {

    @Autowired
    private UsuarioOportunidadesRepository usuarioOportunidadesRepository;

    @Autowired
    private UsuarioOportunidadesMapper usuarioOportunidadesMapper;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private OportunidadesRepository oportunidadesRepository;

    // Crear una relación usuario-oportunidad.
    public UsuarioOportunidades crearUnUsuarioOportunidad(UsuarioOportunidadesNoIdDTO usuarioOportunidadesNoIdDTO) {
        UsuarioOportunidades usuarioOportunidades = usuarioOportunidadesMapper.usuarioOportunidadesSinId(usuarioOportunidadesNoIdDTO);
        return usuarioOportunidadesRepository.save(usuarioOportunidades);
    }

    //Obtener todas las relaciones de usuario-oportunidades.
    public List<UsuarioOportunidades> obtenerUsuarioOportunidades() {
        return usuarioOportunidadesRepository.findAll();
    }

    //Actualizar una relación de usuario-oportunidades.
    public UsuarioOportunidades actualizarUsuarioOportunidad(Long id, UsuarioOportunidadesNoIdDTO usuarioOportunidadDetails) {

        UsuarioOportunidades usuarioOportunidades = usuarioOportunidadesRepository.findById(id).orElseThrow();

        Usuarios usuarios = usuariosRepository.findById((long) usuarioOportunidadDetails.getUsuarioId().getId()).orElseThrow();
        usuarioOportunidades.setUsuarioId(usuarios);

        Oportunidades oportunidades = oportunidadesRepository.findById((long) usuarioOportunidadDetails.getOportunidadesId().getId()).orElseThrow();
        usuarioOportunidades.setOportunidadesId(oportunidades);

        return usuarioOportunidadesRepository.save(usuarioOportunidades);
    }

    //Obtener usuario-oportunidad por Id.
    public Optional<UsuarioOportunidades> obtenerUsuarioOportunidadPorId(Long id) {
        return usuarioOportunidadesRepository.findById(id);
    }

    //Eliminar un usuario-oportunidad por Id.
    public void eliminarUsuarioOportunidad(Long id) {
        usuarioOportunidadesRepository.deleteById(id);
    }
}