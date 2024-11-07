package com.backendproject.springBackend.usuariooportunidades.controller;

import com.backendproject.springBackend.usuariooportunidades.dto.UsuarioOportunidadesNoIdDTO;
import com.backendproject.springBackend.usuariooportunidades.model.UsuarioOportunidades;
import com.backendproject.springBackend.usuariooportunidades.service.UsuarioOportunidadesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarioOportunidades")
public class UsuarioOportunidadesController {

    @Autowired
    private UsuarioOportunidadesService usuarioOportunidadesService;

    // Crear una instituciónOportunidad.
    @Operation(summary = "Este post permite añadir un nuevo usuarioOportunidad a la tabla 'usuario_oportunidades'.", description = "Para crear un usuarioOportunidad se necesita agregar el id del usuario y el de la oportunidad; al darle click al botón 'Execute', este guardara el usuarioOportunidad y le asignará un Id.")
    @PostMapping
    public UsuarioOportunidades crearUsuarioOportunidad(@RequestBody UsuarioOportunidadesNoIdDTO usuarioOportunidadesNoIdDTO) {
        return usuarioOportunidadesService.crearUnUsuarioOportunidad(usuarioOportunidadesNoIdDTO);
    }

    // Obtener todos los usuariosOportunidades.
    @Operation(summary = "Este Get muestra todos los usuariosOportunidades de la tabla 'usuario_oportunidades'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<UsuarioOportunidades> obtenerUsuariosOportunidades() {
        return usuarioOportunidadesService.obtenerUsuarioOportunidades();
    }

    //Actualizar un usuarioOportunidad.
    @Operation(summary = "Este put actualiza un usuarioOportunidades de la tabla 'usuario_oportunidades' mediante su Id.", description = "Este método permite modificar todos los datos menos el Id ya que el Id es único y este se genera automáticamente.")
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioOportunidades> actualizarUsuarioOportunidad(@PathVariable Long id, @RequestBody UsuarioOportunidadesNoIdDTO usuarioOportunidadDetails) {
        return ResponseEntity.ok(usuarioOportunidadesService.actualizarUsuarioOportunidad(id, usuarioOportunidadDetails));
    }

    //Obtener un usuarioOportunidad por Id.
    @Operation(summary = "Este GET muestra un usuarioOportunidad de la tabla 'usuario_oportunidades' mediante su Id.", description = "Solo hay que agregar el parámetro id del usuarioOportunidad que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioOportunidades> ObtenerUsuarioOportunidadPorId(@PathVariable Long id) {
        Optional<UsuarioOportunidades> usuarioOportunidades = usuarioOportunidadesService.obtenerUsuarioOportunidadPorId(id);
        return usuarioOportunidades.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar un usuarioOportunidad.
    @Operation(summary = "Este DELETE elimina un usuarioOportunidad de la tabla 'usuario_oportunidades' mediante su Id.", description = "Solo se necesita poner el id del usuarioOportunidad a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuarioOportunidad(@PathVariable Long id) {
        usuarioOportunidadesService.eliminarUsuarioOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}