package com.backendproject.springBackend.roles.controller;

import com.backendproject.springBackend.roles.dto.RolesNoIdDTO;
import com.backendproject.springBackend.roles.model.Roles;
import com.backendproject.springBackend.roles.service.RolesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    // Crear un rol.
    @Operation(summary = "Este post permite añadir un nuevo rol a la tabla 'roles'.", description = "Para crear un rol solo se necesita agregar el nombre de este; al darle click al botón 'Execute', este guardara el rol y le asignará un Id.")
    @PostMapping
    public Roles crearRol(@RequestBody RolesNoIdDTO rolesNoIdDTO) {
        return rolesService.crearUnRol(rolesNoIdDTO);
    }

    // Obtener todos los roles.
    @Operation(summary = "Este Get muestra todos los roles de la tabla 'roles'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<Roles> obtenerRoles() {
        return rolesService.obtenerRoles();
    }

    //Actualizar un rol.
    @Operation(summary = "Este put actualiza un rol de la tabla 'roles' mediante su Id.", description = "Este método solo permite modificar el rol ya que el Id es único y este se genera automáticamente.")
    @PutMapping("/{id}")
    public ResponseEntity<Roles> actualizarRol(@PathVariable Long id, @RequestBody RolesNoIdDTO rolesDetails) {
        return ResponseEntity.ok(rolesService.actualizarRol(id, rolesDetails));
    }

    //Obtener un rol por Id.
    @Operation(summary = "Este GET muestra un rol de la tabla 'roles' mediante su Id.", description = "Solo hay que agregar el parámetro id del rol que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<Roles> ObtenerRole(@PathVariable Long id) {
        Optional<Roles> roles = rolesService.obtenerRolPorId(id);
        return roles.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar un rol.
    @Operation(summary = "Este DELETE elimina un rol de la tabla 'roles' mediante su Id.", description = "Solo se necesita poner el id del rol a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolesService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}