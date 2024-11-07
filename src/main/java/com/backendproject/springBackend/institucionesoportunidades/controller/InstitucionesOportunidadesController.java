package com.backendproject.springBackend.institucionesoportunidades.controller;

import com.backendproject.springBackend.institucionesoportunidades.dto.InstitucionesOportunidadesNoIdDTO;
import com.backendproject.springBackend.institucionesoportunidades.model.InstitucionesOportunidades;
import com.backendproject.springBackend.institucionesoportunidades.service.InstitucionesOportunidadesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/institucionesOportunidades")
public class InstitucionesOportunidadesController {

    @Autowired
    private InstitucionesOportunidadesService institucionesOportunidadesService;

    // Crear una instituciónOportunidad.
    @Operation(summary = "Este post permite añadir una nueva instituciónOportunidad a la tabla 'instituciones_oportunidades'.", description = "Para crear una instituciónOportunidad se necesita agregar el id de la institución y el de la oportunidad; al darle click al botón 'Execute', este guardara la instituciónOportunidad y le asignará un Id.")
    @PostMapping
    public InstitucionesOportunidades crearInstitucionOportunidad(@RequestBody InstitucionesOportunidadesNoIdDTO institucionesOportunidadesNoIdDTO) {
        return institucionesOportunidadesService.crearUnaInstitucionOportunidad(institucionesOportunidadesNoIdDTO);
    }

    // Obtener todas las institucionesOportunidades.
    @Operation(summary = "Este Get muestra todas las institucionesOportunidades de la tabla 'instituciones_oportunidades'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<InstitucionesOportunidades> obtenerInstitucionesOportunidades() {
        return institucionesOportunidadesService.obtenerInstitucionesOportunidades();
    }

    //Actualizar una instituciónOportunidad.
    @Operation(summary = "Este put actualiza una institucionOportunidad de la tabla 'instituciones_oportunidades' mediante su Id.", description = "Este método permite modificar todos los datos menos el Id ya que el Id es único y este se genera automáticamente.")
    @PutMapping("/{id}")
    public ResponseEntity<InstitucionesOportunidades> actualizarInstitucionOportunidad(@PathVariable Long id, @RequestBody InstitucionesOportunidadesNoIdDTO institucionOportunidadDetails) {
        return ResponseEntity.ok(institucionesOportunidadesService.actualizarInstitucionOportunidad(id, institucionOportunidadDetails));
    }

    //Obtener una instituciónOportunidad por Id.
    @Operation(summary = "Este GET muestra una instituciónOportunidad de la tabla 'instituciones_oportunidades' mediante su Id.", description = "Solo hay que agregar el parámetro id de la instituciónOportunidad que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<InstitucionesOportunidades> ObtenerInstitucionOportunidadPorId(@PathVariable Long id) {
        Optional<InstitucionesOportunidades> institucionesOportunidades = institucionesOportunidadesService.obtenerInstitucionOportunidadPorId(id);
        return institucionesOportunidades.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar una instituciónOportunidad.
    @Operation(summary = "Este DELETE elimina una instituciónOportunidad de la tabla 'instituciones_oportunidades' mediante su Id.", description = "Solo se necesita poner el id de la instituciónOportunidad a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstitucionOportunidad(@PathVariable Long id) {
        institucionesOportunidadesService.eliminarInstitucionOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}