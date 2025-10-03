package com.hackthon.Service;

import com.hackthon.Entity.Comentario;

import java.util.List;
import java.util.Optional;

public interface ComentarioService {

    Comentario guardar(Comentario comentario);

    void eliminar(Long idComentario);

    Optional<Comentario> obtenerPorId(Long idComentario);

    List<Comentario> listarTodos();

    List<Comentario> listarPorProyecto(Long idProyecto);

    List<Comentario> listarPorUsuario(Long idUsuario);
}
