package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "proyecto")
@Data //  Genera getters, setters, toString, equals, hashCode por el uso de la dependencia de Lombok
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 100)
    private String categoria;

    @Column(length = 20)
    private String estado = "inicial";

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    private LocalDateTime fechaActualizacion = LocalDateTime.now();

    private Long idUsuario; // relación con usuario, aquí guardamos solo el ID

    @Column(length = 50)
    private String tipo = "personal";
}
