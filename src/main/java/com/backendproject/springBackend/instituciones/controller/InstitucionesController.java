package com.backendproject.springBackend.instituciones.controller;

import com.backendproject.springBackend.instituciones.dto.InstitucionesNoIdDTO;
import com.backendproject.springBackend.instituciones.model.Instituciones;
import com.backendproject.springBackend.instituciones.service.InstitucionesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instituciones")
public class InstitucionesController {

    @Autowired
    private InstitucionesService institucionesService;

    // Crear una institución.
    @Operation(summary = "Este post permite añadir una nueva institución a la tabla 'instituciones'.", description = "Para crear una institución se necesita agregar el nombre de la institución, su dirección y el Id de la región en la que esta ubicada; al darle click al botón 'Execute', este guardara la institución y le asignará un Id.")
    @PostMapping
    public Instituciones crearInstitucion(@RequestBody InstitucionesNoIdDTO institucionesNoIdDTO) {
        return institucionesService.crearUnaInstitucion(institucionesNoIdDTO);
    }

    // Obtener todas las instituciones.
    @Operation(summary = "Este Get muestra todas las instituciones de la tabla 'instituciones'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<Instituciones> obtenerInstituciones() {
        return institucionesService.obtenerInstituciones();
    }

    //Actualizar una institución.
    @Operation(summary = "Este put actualiza una institución de la tabla 'instituciones' mediante su Id.", description = "Este método permite modificar todos los datos menos el Id ya que el Id es único y este se genera automáticamente.")
    @PutMapping("/{id}")
    public ResponseEntity<Instituciones> actualizarInstitucion(@PathVariable Long id, @RequestBody InstitucionesNoIdDTO institucionDetails) {
        return ResponseEntity.ok(institucionesService.actualizarInstitucion(id, institucionDetails));
    }

    //Obtener una institución por Id.
    @Operation(summary = "Este GET muestra una institución de la tabla 'instituciones' mediante su Id.", description = "Solo hay que agregar el parámetro id de la institución que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<Instituciones> ObtenerInstitucionPorId(@PathVariable Long id) {
        Optional<Instituciones> instituciones = institucionesService.obtenerInstitucionPorId(id);
        return instituciones.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar una institución.
    @Operation(summary = "Este DELETE elimina una institución de la tabla 'instituciones' mediante su Id.", description = "Solo se necesita poner el id de la institución a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInstitucion(@PathVariable Long id) {
        institucionesService.eliminarInstitucion(id);
        return ResponseEntity.noContent().build();
    }
}