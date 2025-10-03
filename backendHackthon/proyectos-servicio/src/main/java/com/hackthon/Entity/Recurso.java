package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecurso;

    @ManyToOne
    @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto", foreignKey = @ForeignKey(name = "fk_recurso_proyecto"))
    private Long idproyecto;

    @Column(nullable = false, length = 200)
    private String nombre;

    @Lob
    private String url;

    @Lob
    private String descripcion;

    private Long idUsuario;  // Solo almacena el ID del usuario (sin dependencia directa)

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    private String estado = "visible";

    // Constructor vacío para JPA
    public Recurso() {}

    // Constructor con parámetros (opcional)
    public Recurso(Long idproyecto, String nombre, String url, String descripcion, Long idUsuario) {
        this.idproyecto = idproyecto;
        this.nombre = nombre;
        this.url = url;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }
}

