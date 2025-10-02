package com.hackthon.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @NotBlank(message = "El nombre del rol es obligatorio")
    @Column(nullable = false, unique = true, length = 50)
    private String nombreRol; // estudiante, admin, etc
}
