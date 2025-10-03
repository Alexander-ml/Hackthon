package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComentario;

    @ManyToOne
    @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto", foreignKey = @ForeignKey(name = "fk_comentario_proyecto"))
    private Long idproyecto;

    private Long idUsuario;  // Almacena solo el ID del usuario, sin la entidad completa

    @Lob
    private String texto;

    @CreationTimestamp
    private LocalDateTime fecha;

    private String estado = "activo";

    // Constructor vacío para JPA
    public Comentario() {}

    // Constructor con parámetros (opcional)
    public Comentario(Long idproyecto, Long idUsuario, String texto) {
        this.idproyecto = idproyecto;
        this.idUsuario = idUsuario;
        this.texto = texto;
    }
}

