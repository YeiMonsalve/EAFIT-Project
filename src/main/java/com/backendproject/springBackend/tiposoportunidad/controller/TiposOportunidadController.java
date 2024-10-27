package com.backendproject.springBackend.tiposoportunidad.controller;

import com.backendproject.springBackend.tiposoportunidad.dto.TiposOportunidadNoIdDTO;
import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.service.TiposOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tiposOportunidad")
public class TiposOportunidadController {

  @Autowired
  private TiposOportunidadService tiposOportunidadService;

  // Crear un tipo de oportunidad.
  @Operation(summary = "Este post permite añadir un nuevo tipo de oportunidad a la tabla 'tipos_oportunidad'.", description = "Para crear una ubicación solo se necesita agregar el nombre del tipo de oportunidad y su descripción; al darle click al botón 'Execute', este guardara la los datos y le asignará un Id.")
  @PostMapping
  public TiposOportunidad crearTipo(@RequestBody TiposOportunidadNoIdDTO tiposOportunidadNoIdDTO) {
    return tiposOportunidadService.crearUnTipoInformacion(tiposOportunidadNoIdDTO);
  }

  // Obtener todos los tipos de oportunidad.
  @Operation(summary = "Este Get muestra todos los tipos de oportunidad de la tabla 'tipos_oportunidad'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
  @GetMapping
  public List<TiposOportunidad> obtenerTipo() {
    return tiposOportunidadService.obtenerTiposOportunidad();
  }

  //Actualizar un tipo de oportunidad.
  @Operation(summary = "Este put actualiza un tipo de oportunidad de la tabla 'tipos_oportunidad' mediante su Id.", description = "Este método solo permite modificar el nombre de la oportunidad y su descripción ya que el Id es único y este se genera automáticamente. ")
  @PutMapping("/{id}")
  public ResponseEntity<TiposOportunidad> actualizarTipo(@PathVariable Long id, @RequestBody TiposOportunidadNoIdDTO tipoDetails) {
    return ResponseEntity.ok(tiposOportunidadService.actualizarTiposOportunidad(id, tipoDetails));
  }

  //Obtener una ubicación por Id.
  @Operation(summary = "Este GET muestra un tipo de oportunidad de la tabla 'tipos_oportunidad' mediante su Id.", description = "Solo hay que agregar el parámetro id del tipo de oportunidad que queremos ver.")
  @GetMapping("/{id}")
  public ResponseEntity<TiposOportunidad> ObtenerTipoPorId(@PathVariable Long id) {
    Optional<TiposOportunidad> tiposOportunidad = tiposOportunidadService.obtenerTiposOportunidadPorId(id);
    return tiposOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  //Eliminar un tipo de oportunidad.
  @Operation(summary = "Este DELETE elimina un tipo de oportunidad de la tabla 'tipos_oportunidad' mediante su Id.", description = "Solo se necesita poner el id del tipo de oportunidad a eliminar como parámetro.")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminarTipo(@PathVariable Long id) {
    tiposOportunidadService.eliminarTiposOportunidad(id);
    return ResponseEntity.noContent().build();
  }
}
