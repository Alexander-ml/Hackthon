package com.hackthon.Repository;

import com.hackthon.Entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    // Buscar proyectos por título
    List<Proyecto> findByTituloContainingIgnoreCase(String titulo);

    // Buscar proyectos por estado
    List<Proyecto> findByEstado(String estado);

    // Buscar proyectos de un usuario
    List<Proyecto> findByIdUsuario(Long idUsuario);

    // Buscar proyectos por tipo
    List<Proyecto> findByTipo(String tipo);

    // Buscar Proyecto por categoria
    List<Proyecto> findByCategoria(String categoria);
}
