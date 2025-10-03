package com.hackthon.Repository;

import com.hackthon.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    // Buscar todos los comentarios de un proyecto
    List<Comentario> findByIdProyecto(Long idProyecto);

    // Buscar todos los comentarios de un usuario
    List<Comentario> findByIdUsuario(Long idUsuario);

    // Buscar comentarios activos de un proyecto
    List<Comentario> findByIdProyectoAndEstado(Long idProyecto, String estado);
}
