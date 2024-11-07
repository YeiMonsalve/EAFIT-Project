package com.backendproject.springBackend.estadooportunidad.controller;

import com.backendproject.springBackend.estadooportunidad.dto.EstadoOportunidadNoIdDTO;
import com.backendproject.springBackend.estadooportunidad.model.EstadoOportunidad;
import com.backendproject.springBackend.estadooportunidad.service.EstadoOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estadoOportunidad")
public class EstadoOportunidadController {

    @Autowired
    private EstadoOportunidadService estadoOportunidadService;

    // Crear un estado oportunidad.
    @Operation(summary = "Este post permite añadir un nuevo estado de oportunidad a la tabla 'Estado_oportunidad'.", description = "Para crear un estado de oportunidad solo se necesita agregar el nombre de esta; al darle click al botón 'Execute', este guardara el estado de oportunidad y le asignará un Id.")
    @PostMapping
    public EstadoOportunidad crearEstado(@RequestBody EstadoOportunidadNoIdDTO estadoOportunidadNoIdDTO) {
        return estadoOportunidadService.crearUnEstadoOportunidad(estadoOportunidadNoIdDTO);
    }

    //Obtener todos los estados de oportunidad.
    @Operation(summary = "Este Get muestra todos los Estados de Oportunidad de la tabla 'Estado_oportunidad'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<EstadoOportunidad> obtenerEstado() {
        return estadoOportunidadService.obtenerEstadoOportunidad();
    }

    //Actualizar un estado de oportunidad.
    @Operation(summary = "Este put actualiza un estado de oportunidad de la tabla 'Estado_oportunidad' mediante su Id.", description = "Este método solo permite modificar el estado ya que el Id es único y este se genera automáticamente. ")
    @PutMapping("/{id}")
    public ResponseEntity<EstadoOportunidad> actualizarEstado(@PathVariable Long id, @RequestBody EstadoOportunidadNoIdDTO estadoDetails) {
        return ResponseEntity.ok(estadoOportunidadService.actualizarEstadoOportunidad(id, estadoDetails));
    }

    //Obtener un estado oportunidad por Id.
    @Operation(summary = "Este GET muestra un estado de la tabla 'Estado_oportunidad' mediante su Id.", description = "Solo hay que agregar el parámetro id del estado oportunidad que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<EstadoOportunidad> ObtenerEstadoPorId(@PathVariable Long id) {
        Optional<EstadoOportunidad> estadoOportunidad = estadoOportunidadService.obtenerEstadoOportunidadPorId(id);
        return estadoOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar un estado de oportunidad by Id.
    @Operation(summary = "Este DELETE elimina un Estado de oportunidad de la tabla 'Estado_oportunidad' mediante su Id.", description = "Solo se necesita poner el id del estado de oportunidad a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstado(@PathVariable Long id) {
        estadoOportunidadService.eliminarEstadoOportunidad(id);
        return ResponseEntity.noContent().build();
    }

}