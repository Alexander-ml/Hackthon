package com.hackthon.Repository;

import com.hackthon.Entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {

    // Buscar todos los recursos de un proyecto
    List<Recurso> findByIdProyecto(Long idProyecto);

    // Buscar todos los recursos de un usuario
    List<Recurso> findByIdUsuario(Long idUsuario);
}
