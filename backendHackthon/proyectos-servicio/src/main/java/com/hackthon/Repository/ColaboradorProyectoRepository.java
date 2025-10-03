package com.hackthon.Repository;

import com.hackthon.Entity.ColaboradorProyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColaboradorProyectoRepository extends JpaRepository<ColaboradorProyecto, Long> {

    // Buscar todos los colaboradores de un proyecto
    List<ColaboradorProyecto> findByIdProyecto(Long idProyecto);

    // Buscar todos los proyectos de un usuario
    List<ColaboradorProyecto> findByIdUsuario(Long idUsuario);

    // Buscar un colaborador específico en un proyecto
    Optional<ColaboradorProyecto> findByIdProyectoAndIdUsuario(Long idProyecto, Long idUsuario);

    // Buscar colaboradores activos en un proyecto
    List<ColaboradorProyecto> findByIdProyectoAndEstado(Long idProyecto, String estado);
}
