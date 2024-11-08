package com.backendproject.springBackend.usuarios.service;

import com.backendproject.springBackend.roles.model.Roles;
import com.backendproject.springBackend.roles.repository.RolesRepository;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdDTO;
import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdNoRolDTO;
import com.backendproject.springBackend.usuarios.mapper.UsuariosMapper;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import com.backendproject.springBackend.usuarios.repository.UsuariosRepository;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements UserDetailsService {

    private static Logger logger = (Logger) LoggerFactory.getLogger(UsuariosService.class);

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private UsuariosMapper usuariosMapper;

    @Autowired
    private RolesRepository rolesRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        if (usuarios == null) {
            logger.info(() -> "Usuario no encontrado.");
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
        return new org.springframework.security.core.userdetails.User(usuarios.getEmail(), usuarios.getPassword(), getAuthorities(usuarios));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Usuarios usuarios) {
        logger.info(usuarios::toString);
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_" + usuarios.getIdRole().getRol()));
    }

    // Crear un Usuario.
    public Usuarios crearUnUsuario(UsuariosNoIdNoRolDTO usuariosNoIdNoRolDTO) {
        Usuarios usuarios = usuariosMapper.usuariosNoIdNoRol(usuariosNoIdNoRolDTO);

        usuarios.setPassword(passwordEncoder().encode(usuariosNoIdNoRolDTO.getPassword()));

        Roles roles = rolesRepository.findByRol("User");

        usuarios.setIdRole(roles);

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
        usuarios.setEmail(usuariosDetails.getEmail());
        usuarios.setPassword(usuariosDetails.getPassword());
        usuarios.setBirthday(usuariosDetails.getBirthday());

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