package com.hackthon.Entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProyecto;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Lob
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String estado = "inicial";

    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

    // En lugar de usar la entidad Usuario directamente, usamos el idUsuario.
    private Long idUsuario;  // Este campo solo almacena el ID del usuario

    @Column(nullable = false, length = 50)
    private String tipo = "personal";

    // Constructor vacío para JPA
    public Proyecto() {}

    // Constructor con parámetros
    public Proyecto(String titulo, String descripcion, String estado, String tipo, Long idUsuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
        this.idUsuario = idUsuario;
    }
}

