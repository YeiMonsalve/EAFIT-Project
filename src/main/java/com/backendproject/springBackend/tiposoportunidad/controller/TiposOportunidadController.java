package com.backendproject.springBackend.tiposoportunidad.controller;

import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.service.TiposOportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tipos-oportunidad")
public class TiposOportunidadController {
  @Autowired
  private TiposOportunidadService tiposOportunidadService;

  @PostMapping
  public TiposOportunidad createTiposDeOportunidad(@RequestBody TiposOportunidad tiposOportunidad){
    return tiposOportunidadService.createTipoDeOportunidad(tiposOportunidad);
  }

  @GetMapping
  public List<TiposOportunidad> getAllTiposDeOportunidad(){
    return tiposOportunidadService.tiposOportunidadFindAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TiposOportunidad> getTiposDeOportunidadById(@PathVariable Long id){
    Optional<TiposOportunidad> tiposOportunidad = tiposOportunidadService.tiposOportunidadFindById(id);
    return tiposOportunidad.map(ResponseEntity::ok).orElseGet(() ->
        ResponseEntity.notFound().build());
  }

  @PutMapping("/{id}")
  public ResponseEntity<TiposOportunidad> updateTiposDeOportunidad(@PathVariable Long id, @RequestBody TiposOportunidad tiposOportunidad){
    return  ResponseEntity.ok(tiposOportunidadService.updateTiposDeOportunidad(id, tiposOportunidad));
  }

  @DeleteMapping("/{id}")
  public  ResponseEntity<Void> deleteTiposDeOportunidad(@PathVariable Long id){
    tiposOportunidadService.deleteTiposDeOportunidad(id);
    return ResponseEntity.noContent().build();
  }
}
