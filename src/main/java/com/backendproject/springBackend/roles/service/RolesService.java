package com.backendproject.springBackend.roles.service;

import com.backendproject.springBackend.roles.dto.RolesNoIdDTO;
import com.backendproject.springBackend.roles.mapper.RolesMapper;
import com.backendproject.springBackend.roles.model.Roles;
import com.backendproject.springBackend.roles.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private RolesMapper rolesMapper;

    // Crear un rol.
    public Roles crearUnRol(RolesNoIdDTO rolesNoIdDTO) {
        Roles roles = rolesMapper.rolSinId(rolesNoIdDTO);
        return rolesRepository.save(roles);
    }

    //Obtener todos los roles.
    public List<Roles> obtenerRoles() {
        return rolesRepository.findAll();
    }

    //Actualizar un rol.
    public Roles actualizarRol(Long id, RolesNoIdDTO rolDetails) {
        Roles roles = rolesRepository.findById(id).orElseThrow();
        roles.setRol(rolDetails.getRol());
        return rolesRepository.save(roles);
    }

    //Obtener rol por Id.
    public Optional<Roles> obtenerRolPorId(Long id) {
        return rolesRepository.findById(id);
    }

    //Eliminar un rol por Id.
    public void eliminarRol(Long id) {
        rolesRepository.deleteById(id);
    }
}