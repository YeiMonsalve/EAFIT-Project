package com.backendproject.springBackend.tiposoportunidad.service;

import com.backendproject.springBackend.tiposoportunidad.model.TiposOportunidad;
import com.backendproject.springBackend.tiposoportunidad.repository.TiposOportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiposOportunidadService {
  @Autowired
  private TiposOportunidadRepository tiposOportunidadRepository;

  public TiposOportunidad createTipoDeOportunidad(TiposOportunidad tiposOportunidad){
    return tiposOportunidadRepository.save(tiposOportunidad);
  }

  public Optional<TiposOportunidad> tiposOportunidadFindById(Long id){
    return tiposOportunidadRepository.findById(id);
  }

  public List<TiposOportunidad> tiposOportunidadFindAll(){
    return tiposOportunidadRepository.findAll();
  }

  public TiposOportunidad updateTiposDeOportunidad(Long id, TiposOportunidad details){
    TiposOportunidad tiposOportunidad = tiposOportunidadRepository.findById(id).orElseThrow();
    tiposOportunidad.setDescripcion(details.getDescripcion());
    tiposOportunidad.setNombre(details.getNombre());
    return tiposOportunidadRepository.save(tiposOportunidad);
  }

  public void deleteTiposDeOportunidad(Long id){
    tiposOportunidadRepository.deleteById(id);
  }

}
