package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblioteca.model.Receta;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}

