package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Receta;
import com.biblioteca.repository.RecetaRepository;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    // Listar todas las recetas
    public List<Receta> listarRecetas() {
        return recetaRepository.findAll();
    }

    // Obtener una receta por su ID
    public Optional<Receta> obtenerReceta(Long id) {
        return recetaRepository.findById(id);
    }

    // Guardar una nueva receta o actualizar una existente
    public Receta guardarReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    // Eliminar una receta por su ID
    public void eliminarReceta(Long id) {
        recetaRepository.deleteById(id);
    }
}
