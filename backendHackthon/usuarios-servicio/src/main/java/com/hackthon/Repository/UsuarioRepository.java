package com.hackthon.Repository;

import com.hackthon.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por email para login, validaciones de registro
    Optional<Usuario> findByCorreo (String correo);

    // Verificar si ya existe un email registrado
    boolean existsByCorreo (String Correo);
}
