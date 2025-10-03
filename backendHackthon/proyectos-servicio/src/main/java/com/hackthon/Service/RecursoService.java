package com.hackthon.Service;

import com.hackthon.Entity.Recurso;

import java.util.List;

public interface RecursoService {
    Recurso crearRecurso(Recurso recurso);
    Recurso obtenerRecursoPorId(Long id);
    List<Recurso> obtenerRecursosPorProyecto(Long idProyecto);
    Recurso actualizarRecurso(Long id, Recurso recurso);
    void eliminarRecurso(Long id);
}