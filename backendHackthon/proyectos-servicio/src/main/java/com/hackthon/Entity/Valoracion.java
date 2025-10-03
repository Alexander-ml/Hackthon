package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Valoracion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idValoracion;

    @ManyToOne
    @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto", foreignKey = @ForeignKey(name = "fk_valoracion_proyecto"))
    private Long idproyecto;

    private Long idUsuario;  // Almacena solo el ID del usuario, sin la entidad completa

    @Column(nullable = false)
    private int puntaje;  // Puntaje debe estar entre 1 y 5, validado en la base de datos

    @CreationTimestamp
    private LocalDateTime fecha;

    private String estado = "activo";

    // Constructor vacío para JPA
    public Valoracion() {}

    // Constructor con parámetros (opcional)
    public Valoracion(Long idproyecto, Long idUsuario, int puntaje) {
        this.idproyecto = idproyecto;
        this.idUsuario = idUsuario;
        this.puntaje = puntaje;
    }
}
