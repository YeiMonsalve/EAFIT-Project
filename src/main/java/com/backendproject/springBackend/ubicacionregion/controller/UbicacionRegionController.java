package com.backendproject.springBackend.ubicacionregion.controller;

import com.backendproject.springBackend.ubicacionregion.dto.UbicacionRegionNoIdDTO;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import com.backendproject.springBackend.ubicacionregion.service.UbicacionRegionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ubicacionRegion")
public class UbicacionRegionController {

    @Autowired
    private UbicacionRegionService ubicacionRegionService;

    // Crear una ubicación.
    @Operation(summary = "Este post permite añadir una nueva ubicación a la tabla 'ubicacion_region'.", description = "Para crear una ubicación solo se necesita agregar el nombre de esta; al darle click al botón 'Execute', este guardara la ubicación y le asignará un Id.")
    @PostMapping
    public UbicacionRegion crearUbicacion(@RequestBody UbicacionRegionNoIdDTO ubicacionRegionNoIdDTO) {
        return ubicacionRegionService.crearUnaUbicacionRegion(ubicacionRegionNoIdDTO);
    }

    // Obtener todas las ubicaciones.
    @Operation(summary = "Este Get muestra todas las ubicaciones de la tabla 'ubicacion_region'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<UbicacionRegion> obtenerUbicacion() {
        return ubicacionRegionService.obtenerUbicacionesRegion();
    }

    //Actualizar una ubicación.
    @Operation(summary = "Este put actualiza una ubicación de la tabla 'ubicacion_region' mediante su Id.", description = "Este método solo permite modificar la región ya que el Id es único y este se genera automáticamente. ")
    @PutMapping("/{id}")
    public ResponseEntity<UbicacionRegion> actualizarUbicacion(@PathVariable Long id, @RequestBody UbicacionRegionNoIdDTO ubicacionDetails) {
        return ResponseEntity.ok(ubicacionRegionService.actualizarUbicacionRegion(id, ubicacionDetails));
    }

    //Obtener una ubicación por Id.
    @Operation(summary = "Este GET muestra una ubicación de la tabla 'ubicacion_region' mediante su Id.", description = "Solo hay que agregar el parámetro id de la ubicación que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<UbicacionRegion> ObtenerUbicacionPorId(@PathVariable Long id) {
        Optional<UbicacionRegion> ubicacionRegion = ubicacionRegionService.obtenerUbicacionRegionPorId(id);
        return ubicacionRegion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar una ubicación.
    @Operation(summary = "Este DELETE elimina una ubicación de la tabla 'ubicacion_region' mediante su Id.", description = "Solo se necesita poner el id de la ubicación a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUbicacion(@PathVariable Long id) {
        ubicacionRegionService.eliminarUbicacionRegion(id);
        return ResponseEntity.noContent().build();
    }
}