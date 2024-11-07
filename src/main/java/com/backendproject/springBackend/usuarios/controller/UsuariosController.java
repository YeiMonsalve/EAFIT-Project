package com.backendproject.springBackend.usuarios.controller;

import com.backendproject.springBackend.usuarios.dto.UsuariosNoIdDTO;
import com.backendproject.springBackend.usuarios.model.Usuarios;
import com.backendproject.springBackend.usuarios.service.UsuariosService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private UsuariosService usuariosService;

    // Crear un rol.
    @Operation(summary = "Este post permite añadir un nuevo Usuario a la tabla 'usuarios'.", description = "Para crear un usuario solo se necesita agregar el nombre de este; al darle click al botón 'Execute', este guardara el usuario y le asignará un Id.")
    @PostMapping
    public Usuarios crearUsuarios(@RequestBody UsuariosNoIdDTO usuariosNoIdDTO) {
        return usuariosService.crearUnUsuario(usuariosNoIdDTO);
    }

    // Obtener todos los usuarios.
    @Operation(summary = "Este Get muestra todos los usuarios de la tabla 'usuarios'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<Usuarios> obtenerUsuarios() {
        return usuariosService.obtenerUsuarios();
    }

    //Actualizar un usuario.
    @Operation(summary = "Este put actualiza un usuario de la tabla 'usuarios' mediante su Id.", description = "Este método solo permite modificar el usuario ya que el Id es único y este se genera automáticamente.")
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuarios(@PathVariable Long id, @RequestBody UsuariosNoIdDTO usuariosDetails) {
        return ResponseEntity.ok(usuariosService.actualizarUsuarios(id, usuariosDetails));
    }

    //Obtener un usuario por Id.
    @Operation(summary = "Este GET muestra un usuario de la tabla 'usuarios' mediante su Id.", description = "Solo hay que agregar el parámetro id del usuario que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> ObtenerUsuarios(@PathVariable Long id) {
        Optional<Usuarios> usuarios = usuariosService.obtenerUsuariosPorId(id);
        return usuarios.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar un usuario.
    @Operation(summary = "Este DELETE elimina un usuario de la tabla 'usuarios' mediante su Id.", description = "Solo se necesita poner el id del usuario a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarios(@PathVariable Long id) {
        usuariosService.eliminarUsuarios(id);
        return ResponseEntity.noContent().build();
    }
}