package com.hackthon.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ColaboradorProyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColaboradorProyecto;

    @ManyToOne
    @JoinColumn(name = "idProyecto", referencedColumnName = "idProyecto", foreignKey = @ForeignKey(name = "fk_colaborador_proyecto"))
    private Long idproyecto;

    private Long idUsuario;  // Almacena solo el ID del usuario, sin la entidad completa.

    private String rol;

    @CreationTimestamp
    private LocalDateTime fechaUnion;

    private LocalDateTime fechaSalida;
    private String descripcion;
    private String estado = "activo";

    // Constructor vacío para JPA
    public ColaboradorProyecto() {}

    // Constructor con parámetros (opcional)
    public ColaboradorProyecto(Long idproyecto, Long idUsuario, String rol, String descripcion) {
        this.idproyecto = idproyecto;
        this.idUsuario = idUsuario;
        this.rol = rol;
        this.descripcion = descripcion;
    }
}

