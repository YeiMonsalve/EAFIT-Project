package com.backendproject.springBackend.categoriaoportunidad.controller;

import com.backendproject.springBackend.categoriaoportunidad.dto.CategoriaOportunidadNoIdDTO;
import com.backendproject.springBackend.categoriaoportunidad.model.CategoriaOportunidad;
import com.backendproject.springBackend.categoriaoportunidad.service.CategoriaOportunidadService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categoriaOportunidad")
public class CategoriaOportunidadController {

    @Autowired
    private CategoriaOportunidadService categoriaOportunidadService;

    // Crear una categoria.
    @Operation(summary = "Este post permite añadir una nueva categoria a la tabla 'categoria_oportunidad'.", description = "Para crear una categoria solo se necesita agregar el nombre de esta; al darle click al botón 'Execute', este guardara la categoria y le asignará un Id.")
    @PostMapping
    public CategoriaOportunidad crearCategoria(@RequestBody CategoriaOportunidadNoIdDTO categoriaOportunidadNoIdDTO) {
        return categoriaOportunidadService.crearUnaCategoriaOportunidad(categoriaOportunidadNoIdDTO);
    }

    // Obtener todas las categorias.
    @Operation(summary = "Este Get muestra todas las categorias de la tabla 'categoria_oportunidad'.", description = "Este método no necesita de ningún parámetro. Solo hay que darle al botón 'Execute'.")
    @GetMapping
    public List<CategoriaOportunidad> obtenerCategoria() {
        return categoriaOportunidadService.obtenerCategoriaOportunidad();
    }

    //Actualizar una categoria.
    @Operation(summary = "Este put actualiza una categoria de la tabla 'categoria_oportunidad' mediante su Id.", description = "Este método solo permite modificar el nombre de la categoria ya que el Id es único y este se genera automáticamente. ")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaOportunidad> actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaOportunidadNoIdDTO categoriaDetails) {
        return ResponseEntity.ok(categoriaOportunidadService.actualizarCategoriaOportunidad(id, categoriaDetails));
    }

    //Obtener una categoria por Id.
    @Operation(summary = "Este GET muestra una categoria de la tabla 'categoria_oportunidad' mediante su Id.", description = "Solo hay que agregar el parámetro id de la categoria que queremos ver.")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaOportunidad> ObtenerCategoriaPorId(@PathVariable Long id) {
        Optional<CategoriaOportunidad> categoriaOportunidad = categoriaOportunidadService.obtenerCategoriaOportunidadPorId(id);
        return categoriaOportunidad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Eliminar una categoria.
    @Operation(summary = "Este DELETE elimina una categoria de la tabla 'categoria_oportunidad' mediante su Id.", description = "Solo se necesita poner el id de la categoria a eliminar como parámetro.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaOportunidadService.eliminarCategoriaOportunidad(id);
        return ResponseEntity.noContent().build();
    }
}
