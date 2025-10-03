package com.hackthon.Service;

import com.hackthon.Entity.ProyectoCategoria;

import java.util.List;

public interface ProyectoCategoriaService {

    ProyectoCategoria asignarCategoriaAProyecto(Long idProyecto, Long idCategoria);

    void eliminarCategoriaDeProyecto(Long idProyecto, Long idCategoria);

    List<ProyectoCategoria> listarCategoriasPorProyecto(Long idProyecto);

    List<ProyectoCategoria> listarProyectosPorCategoria(Long idCategoria);
}
