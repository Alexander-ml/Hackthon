package com.hackthon.Service;

import com.hackthon.Entity.Evento;

import java.util.List;
import java.util.Optional;

public interface EventoService {

    Evento guardar(Evento evento);

    void eliminar(Long idEvento);

    Optional<Evento> obtenerPorId(Long idEvento);

    List<Evento> listarTodos();

    List<Evento> listarPorCategoria(String categoria);

    List<Evento> listarPorEstado(String estado);

    List<Evento> listarProximos(); // Eventos con fecha_inicio mayor a "ahora"
}
