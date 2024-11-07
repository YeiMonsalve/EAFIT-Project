package com.backendproject.springBackend.oportunidades.controller;

import com.backendproject.springBackend.oportunidades.dto.OportunidadesNoIdDTO;
import com.backendproject.springBackend.oportunidades.model.Oportunidades;
import com.backendproject.springBackend.oportunidades.service.OportunidadesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/oportunidades")
public class OportunidadesController {

    @Autowired
    private OportunidadesService oportunidadesService;

    // Crear una oportunidad.
    @Operation(summary = "Este post permite añadir una nueva oportunidad a la tabla 'oportunidades'.", description = "Para crear una oportunidad se necesita agregar el nombre de la oportunidad y el Id de la categoria, información, estado y tipo de oportunidad; al darle click al botón 'Execute', este guardara la oportunidad y le asignará un Id.")
    @PostMapping
    public Oportunidades crearOportunidad(@RequestBody OportunidadesNoIdDTO oportunidadesNoIdDTO) {
        return oportunidadesService.crearUnaOportunidad(oportunidadesNoIdDTO);
    }

    // Obtener todas las oportunidades.
    @Operation(summary = "Este Get muestra todas las oportunidades de la tabla 'oportunidades'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<Oportunidades> obtenerOportunidades() {
        return oportunidadesService.obtenerOportunidades();
    }

    //Actualizar una oportunidad.
    @Operation(summary = "Este put actualiza una oportunidad de la tabla 'oportunidades' mediante su Id.", description = "Este método permite modificar todos los datos menos el Id de la oportunidad ya que el Id es único y este se genera automáticamente.")
    @PutMapping("/{id}")
    public ResponseEntity<Oportunidades> actualizarOportunidad(@PathVariable Long id, @RequestBody OportunidadesNoIdDTO oportunidadDetails) {
        return ResponseEntity.ok(oportunidadesService.actualizarOportunidad(id, oportunidadDetails));
    }

    //Obtener una oportunidad por Id.
    @Operation(summary = "Este GET muestra una oportunidad de la tabla 'oportunidades' mediante su Id.", description = "Solo hay que agregar el parámetro id de la oportunidad que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<Oportunidades> ObtenerOportunidadPorId(@PathVariable Long id) {
        Optional<Oportunidades> oportunidades = oportunidadesService.obtenerOportunidadPorId(id);
        return oportunidades.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar una oportunidad.
    @Operation(summary = "Este DELETE elimina una oportunidad de la tabla 'oportunidades' mediante su Id.", description = "Solo se necesita poner el id de la oportunidad a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOportunidad(@PathVariable Long id) {
        oportunidadesService.eliminarOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}