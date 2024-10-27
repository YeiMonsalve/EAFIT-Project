package com.backendproject.springBackend.informacionoportunidad.controller;

import com.backendproject.springBackend.informacionoportunidad.dto.InformacionOportunidadNoIdDTO;
import com.backendproject.springBackend.informacionoportunidad.model.InformacionOportunidad;
import com.backendproject.springBackend.informacionoportunidad.service.InformacionOportunidadService;
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

    @PostMapping
    public InformacionOportunidad crearInformacionOportunidad(@RequestBody InformacionOportunidadNoIdDTO informacionOportunidadNoIdDTO) {
        return informacionOportunidadService.crearInformacionOportunidad(informacionOportunidadNoIdDTO);
    }

    @GetMapping
    public List<InformacionOportunidad> obtenerInformacionOportunidades() {
        return informacionOportunidadService.obtenerInformacionOportunidades();
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformacionOportunidad> actualizarInformacionOportunidad(
            @PathVariable int id,
            @RequestBody InformacionOportunidadNoIdDTO informacionDetails) {
        return ResponseEntity.ok(informacionOportunidadService.actualizarInformacionOportunidad(id, informacionDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionOportunidad> obtenerInformacionOportunidadPorId(@PathVariable int id) {
        Optional<InformacionOportunidad> informacionOportunidad = informacionOportunidadService.obtenerInformacionOportunidadPorId(id);
        return informacionOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInformacionOportunidad(@PathVariable int id) {
        informacionOportunidadService.eliminarInformacionOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}
