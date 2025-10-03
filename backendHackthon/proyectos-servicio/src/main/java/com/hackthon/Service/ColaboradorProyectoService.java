package com.hackthon.Service;

import com.hackthon.Entity.ColaboradorProyecto;

import java.util.List;
import java.util.Optional;

public interface ColaboradorProyectoService {

    ColaboradorProyecto guardar(ColaboradorProyecto colaboradorProyecto);

    void eliminar(Long idColaboradorProyecto);

    Optional<ColaboradorProyecto> obtenerPorId(Long idColaboradorProyecto);

    List<ColaboradorProyecto> listarTodos();

    List<ColaboradorProyecto> listarPorProyecto(Long idProyecto);

    List<ColaboradorProyecto> listarPorUsuario(Long idUsuario);

    Optional<ColaboradorProyecto> buscarPorProyectoYUsuario(Long idProyecto, Long idUsuario);
}
