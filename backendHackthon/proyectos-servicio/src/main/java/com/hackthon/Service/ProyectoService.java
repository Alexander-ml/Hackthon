package com.hackthon.Service;

import com.hackthon.Entity.Proyecto;

import java.util.List;
import java.util.Optional;

public interface ProyectoService {

    Proyecto crearProyecto(Proyecto proyecto);

    Proyecto actualizarProyecto(Long idProyecto, Proyecto proyecto);

    void eliminarProyecto(Long idProyecto);

    Optional<Proyecto> obtenerPorId(Long idProyecto);

    List<Proyecto> listarTodos();

    List<Proyecto> listarPorUsuario(Long idUsuario);

    List<Proyecto> listarPorCategoria(String categoria);

    List<Proyecto> listarPorEstado(String estado);

    List<Proyecto> listarPorTipo(String tipo);
}
