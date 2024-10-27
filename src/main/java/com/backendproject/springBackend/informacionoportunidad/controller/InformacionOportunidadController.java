package com.backendproject.springBackend.informacionoportunidad.controller;

import com.backendproject.springBackend.informacionoportunidad.dto.InformacionOportunidadNoIdDTO;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.informacionoportunidad.service.InformacionOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/informacionOportunidad")
public class InformacionOportunidadController {

    @Autowired
    private InformacionOportunidadService informacionOportunidadService;

    // Crear una información.
    @Operation(summary = "Este post permite añadir una nueva información a la tabla 'informacion_oportunidad'.", description = "Para crear una información solo se necesita agregar el nombre de esta; al darle click al botón 'Execute', este guardara la información y le asignará un Id.")
    @PostMapping
    public InformacionOportunidad crearInformacion(@RequestBody InformacionOportunidadNoIdDTO informacionOportunidadNoIdDTO) {
        return informacionOportunidadService.crearInformacionOportunidad(informacionOportunidadNoIdDTO);
    }

    // Obtener todas las ubicaciones.
    @Operation(summary = "Este Get muestra todas las informaciones de la tabla 'informacion_oportunidad'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<InformacionOportunidad> obtenerInformacion() {
        return informacionOportunidadService.obtenerInformacionOportunidad();
    }

    //Actualizar una información.
    @Operation(summary = "Este put actualiza una información de la tabla 'informacion_oportunidad' mediante su Id.", description = "Este método solo permite modificar la info ya que el Id es único y este se genera automáticamente. ")
    @PutMapping("/{id}")
    public ResponseEntity<InformacionOportunidad> actualizarInformacion(@PathVariable Long id, @RequestBody InformacionOportunidadNoIdDTO informacionDetails) {
        return ResponseEntity.ok(informacionOportunidadService.actualizarInformacionOportunidad(id, informacionDetails));
    }

    //Obtener una información por Id.
    @Operation(summary = "Este GET muestra una información de la tabla 'informacion_oportunidad' mediante su Id.", description = "Solo hay que agregar el parámetro id de la información que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<InformacionOportunidad> obtenerInformacionPorId(@PathVariable Long id) {
        Optional<InformacionOportunidad> informacionOportunidad = informacionOportunidadService.obtenerInformacionOportunidadPorId(id);
        return informacionOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar una información.
    @Operation(summary = "Este DELETE elimina una información de la tabla 'informacion_oportunidad' mediante su Id.", description = "Solo se necesita poner el id de la información a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInformacion(@PathVariable Long id) {
        informacionOportunidadService.eliminarInformacionOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}