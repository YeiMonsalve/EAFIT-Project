package com.backendproject.springBackend.categoriaoportunidad.service;

import com.backendproject.springBackend.categoriaoportunidad.dto.CategoriaOportunidadNoIdDTO;
import com.backendproject.springBackend.categoriaoportunidad.mapper.CategoriaOportunidadMapper;
import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.categoriaoportunidad.repository.CategoriaOportunidadRepository;
import com.backendproject.springBackend.ubicacionregion.model.UbicacionRegion;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaOportunidadService {

    @Autowired
    private CategoriaOportunidadRepository categoriaOportunidadRepository;

    @Autowired
    private CategoriaOportunidadMapper categoriaOportunidadMapper;

    // Crear una categoria.
    public CategoriaOportunidad crearUnaCategoriaOportunidad(CategoriaOportunidadNoIdDTO categoriaOportunidadNoIdDTO) {
        CategoriaOportunidad categoriaOportunidad = categoriaOportunidadMapper.categoriaOportunidadSinId(categoriaOportunidadNoIdDTO);
        return categoriaOportunidadRepository.save(categoriaOportunidad);
    }

    //Obtener todas las categorias.
    public List<CategoriaOportunidad> obtenerCategoriaOportunidad() {
        return categoriaOportunidadRepository.findAll();
    }

    //Actualizar una categoria.
    public CategoriaOportunidad actualizarCategoriaOportunidad(Long id, CategoriaOportunidadNoIdDTO categoriaDetails) {
        CategoriaOportunidad categoriaOportunidad = categoriaOportunidadRepository.findById(id).orElseThrow();
        categoriaOportunidad.setCategoria(categoriaDetails.getCategoria());
        return categoriaOportunidadRepository.save(categoriaOportunidad);
    }

    //Obtener categoria por Id.
    public Optional<CategoriaOportunidad> obtenerCategoriaOportunidadPorId(Long id) {
        return categoriaOportunidadRepository.findById(id);
    }

    //Eliminar una categoria por Id.
    public void eliminarCategoriaOportunidad(Long id) {
        categoriaOportunidadRepository.deleteById(id);
    }

    @PostConstruct
    public void initializeCategoria() {
        if (categoriaOportunidadRepository.findAll().isEmpty()) {
            categoriaOportunidadRepository.save(new CategoriaOportunidad(null, "Formatica"));
            categoriaOportunidadRepository.save(new CategoriaOportunidad(null, "Socioeconómica"));
            categoriaOportunidadRepository.save(new CategoriaOportunidad(null, "Bootcamps"));
        }
    }
}