package com.hackthon.Service;

import com.hackthon.Entity.Notificacion;

import java.util.List;
import java.util.Optional;

public interface NotificacionService {

    Notificacion crearNotificacion(Notificacion notificacion);

    void eliminarNotificacion(Long idNotificacion);

    Optional<Notificacion> obtenerPorId(Long idNotificacion);

    List<Notificacion> listarPorUsuario(Long idUsuario);

    List<Notificacion> listarNoLeidas(Long idUsuario);

    void marcarComoLeida(Long idNotificacion);

    void marcarTodasComoLeidas(Long idUsuario);
}
