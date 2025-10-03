package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "inscripcion_oportunidad")
@Data
public class InscripcionOportunidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;

    @Column(nullable = false)
    private Long idUsuario;

    @Column(nullable = false)
    private Long idOportunidad;

    @Column(nullable = false)
    private LocalDateTime fechaInscripcion = LocalDateTime.now();

    @Column(length = 20, nullable = false)
    private String estado = "inscrito";
}
