package com.hackthon.Repository;

import com.hackthon.Entity.Rol;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Log> {
    // Buscar rol por su nombre puede ser "ADMIN", "ESTUDIANTE"
    Optional<Rol> findByNombreRol(String nombreRol);
}
