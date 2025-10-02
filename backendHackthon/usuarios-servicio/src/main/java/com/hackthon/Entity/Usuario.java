package com.hackthon.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // para construir objetos con patron builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombres;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Formato de correo inválido")
    @Column(unique = true, nullable = false)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String contrasena;

    @NotBlank(message = "La carrera es obligatoria")
    private String carrera;

    @Size(max = 255, message = "Máximo 255 caracteres en intereses")
    private String intereses;

    @NotNull(message = "El estado no puede ser nulo")
    private String estado; // activo, inactivo, suspendido

    @Column(name = "fecha_registro", updatable = false)
    private LocalDate fechaRegistro = LocalDate.now();

}
