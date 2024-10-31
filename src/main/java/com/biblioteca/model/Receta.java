package com.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "RECETA")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotNull(message = "El nombre no puede ser nulo")
    @Size(min = 1, max = 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    @Column(name = "NOMBRE")
    private String nombre;

    @NotNull(message = "Los ingredientes no pueden ser nulos")
    @Size(min = 1, max = 500, message = "Los ingredientes deben tener entre 1 y 500 caracteres")
    @Column(name = "INGREDIENTES")
    private String ingredientes;

    @NotNull(message = "Las instrucciones no pueden ser nulas")
    @Size(min = 1, max = 1000, message = "Las instrucciones deben tener entre 1 y 1000 caracteres")
    @Column(name = "INSTRUCCIONES")
    private String instrucciones;

    @Min(value = 1, message = "El tiempo de cocción debe ser al menos 1 minuto")
    @Column(name = "TIEMPO_COCCION")
    private int tiempoCoccion; // Tiempo en minutos

    @NotNull(message = "La dificultad no puede ser nula")
    @Size(min = 1, max = 50, message = "La dificultad debe tener entre 1 y 50 caracteres")
    @Column(name = "DIFICULTAD")
    private String dificultad;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public int getTiempoCoccion() {
        return tiempoCoccion;
    }

    public void setTiempoCoccion(int tiempoCoccion) {
        this.tiempoCoccion = tiempoCoccion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}
