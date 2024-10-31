package com.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.exception.ResourceNotFoundException;
import com.biblioteca.model.Receta;
import com.biblioteca.service.RecetaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/recetas")
@Validated
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    // Listar todas las recetas
    @GetMapping
    public ResponseEntity<List<Receta>> listarRecetas() {
        List<Receta> recetas = recetaService.listarRecetas();
        return ResponseEntity.ok(recetas);
    }

    // Crear una nueva receta con validación
    @PostMapping
    public ResponseEntity<Receta> crearReceta(@Valid @RequestBody Receta receta) {
        Receta nuevaReceta = recetaService.guardarReceta(receta);
        return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED); // Devolver 201 Created
    }

    // Obtener una receta por su ID con manejo de excepción
    @GetMapping("/{id}")
    public ResponseEntity<Receta> obtenerReceta(@PathVariable Long id) {
        Receta receta = recetaService.obtenerReceta(id)
                .orElseThrow(() -> new ResourceNotFoundException("La receta con ID " + id + " no fue encontrada."));
        return ResponseEntity.ok(receta);
    }

    // Eliminar una receta por su ID con manejo de excepción
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReceta(@PathVariable Long id) {
        // Verifica si la receta existe, si no, lanza la excepción
        recetaService.obtenerReceta(id)
                .orElseThrow(() -> new ResourceNotFoundException("La receta con ID " + id + " no fue encontrada."));

        // Elimina la receta si existe
        recetaService.eliminarReceta(id);

        return ResponseEntity.noContent().build(); // Devolver 204 No Content
    }

    // Actualizar una receta existente con manejo de excepción
    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizarReceta(@PathVariable Long id, @Valid @RequestBody Receta detallesReceta) {
        Receta receta = recetaService.obtenerReceta(id)
                .orElseThrow(() -> new ResourceNotFoundException("La receta con ID " + id + " no fue encontrada."));

        receta.setNombre(detallesReceta.getNombre());
        receta.setIngredientes(detallesReceta.getIngredientes());
        receta.setInstrucciones(detallesReceta.getInstrucciones());
        receta.setTiempoCoccion(detallesReceta.getTiempoCoccion());
        receta.setDificultad(detallesReceta.getDificultad());
        
        Receta recetaActualizada = recetaService.guardarReceta(receta);
        return ResponseEntity.ok(recetaActualizada);
    }
}
