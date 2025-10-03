package com.hackthon.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "comentario")
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    private Long idProyecto; // relación con Proyecto

    private Long idUsuario;  // relación con Usuario

    @Column(columnDefinition = "TEXT", nullable = false)
    private String texto;

    private LocalDateTime fecha = LocalDateTime.now();

    @Column(length = 20)
    private String estado = "activo";
}
