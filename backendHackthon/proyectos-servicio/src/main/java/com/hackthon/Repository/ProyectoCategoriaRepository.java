package com.hackthon.Repository;


import com.hackthon.Entity.ProyectoCategoria;
import com.hackthon.Entity.ProyectoCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProyectoCategoriaRepository extends JpaRepository<ProyectoCategoria, ProyectoCategoriaId> {

    // Buscar todas las categorías de un proyecto
    List<ProyectoCategoria> findByIdProyecto(Long idProyecto);

    // Buscar todos los proyectos de una categoría
    List<ProyectoCategoria> findByIdCategoria(Long idCategoria);

    // Elimina proyecto con id
    void deleteByProyectoIdProyecto(Long idProyecto);

    // Elimina categoria
    void deleteByCategoriaIdCategoria(Long idCategoria);
}
