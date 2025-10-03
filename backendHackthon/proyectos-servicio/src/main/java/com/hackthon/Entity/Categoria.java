package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    // Constructor vacío para JPA
    public Categoria() {}

    // Constructor con parámetros (opcional)
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
