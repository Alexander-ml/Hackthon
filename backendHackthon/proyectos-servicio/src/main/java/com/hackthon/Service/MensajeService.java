package com.hackthon.Service;

import com.hackthon.Entity.Mensaje;

import java.util.List;
import java.util.Optional;

public interface MensajeService {

    Mensaje enviarMensaje(Mensaje mensaje);

    void eliminarMensaje(Long idMensaje);

    Optional<Mensaje> obtenerPorId(Long idMensaje);

    List<Mensaje> listarMensajesEntreUsuarios(Long idEmisor, Long idReceptor);

    List<Mensaje> listarMensajesRecibidos(Long idReceptor);

    List<Mensaje> listarMensajesEnviados(Long idEmisor);

    void marcarComoLeido(Long idMensaje);
}
