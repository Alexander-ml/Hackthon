package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table (name = "colaborador_proyecto")
@Data
public class ColaboradorProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaboradorProyecto;

    private Long idProyecto; // relación con Proyecto

    private Long idUsuario; // relación con Usuario

    @Column(length = 50)
    private String rol;

    private LocalDateTime fechaUnion = LocalDateTime.now();

    private LocalDateTime fechaSalida;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 20)
    private String estado = "activo";
}
