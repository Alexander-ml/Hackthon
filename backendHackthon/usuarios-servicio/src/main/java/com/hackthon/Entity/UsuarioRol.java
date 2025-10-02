package com.hackthon.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario_rol")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Debe estar asociado a un usuario")
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @NotNull(message = "Debe estar asociado a un rol")
    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio = LocalDate.now();
}
