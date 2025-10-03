package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "valoracion")
@Data
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idValoracion;

    private Long idProyecto;

    private Long idUsuario;

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private Integer puntaje;

    private LocalDateTime fecha = LocalDateTime.now();

    @Column(length = 20)
    private String estado = "activo";
}