package com.hackthon.Repository;

import com.hackthon.Entity.Valoracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Long> {

    // Buscar todas las valoraciones de un proyecto
    List<Valoracion> findByIdProyecto(Long idProyecto);

    // Buscar todas las valoraciones de un usuario
    List<Valoracion> findByIdUsuario(Long idUsuario);

    // Buscar la valoración de un usuario específico en un proyecto
    Valoracion findByIdProyectoAndIdUsuario(Long idProyecto, Long idUsuario);
}
