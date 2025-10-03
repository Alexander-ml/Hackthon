package com.hackthon.Service;

import com.hackthon.Entity.Notificacion;
import com.hackthon.Repository.NotificacionRepository;
import com.hackthon.Service.NotificacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionServiceImpl(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    @Override
    public Notificacion crearNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public void eliminarNotificacion(Long idNotificacion) {
        notificacionRepository.deleteById(idNotificacion);
    }

    @Override
    public Optional<Notificacion> obtenerPorId(Long idNotificacion) {
        return notificacionRepository.findById(idNotificacion);
    }

    @Override
    public List<Notificacion> listarPorUsuario(Long idUsuario) {
        return notificacionRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<Notificacion> listarNoLeidas(Long idUsuario) {
        return notificacionRepository.findByIdUsuarioAndEstado(idUsuario, "no_leida");
    }

    @Override
    public void marcarComoLeida(Long idNotificacion) {
        Optional<Notificacion> opt = notificacionRepository.findById(idNotificacion);
        if (opt.isPresent()) {
            Notificacion notif = opt.get();
            notif.setEstado("leida");
            notificacionRepository.save(notif);
        }
    }

    @Override
    public void marcarTodasComoLeidas(Long idUsuario) {
        List<Notificacion> pendientes = notificacionRepository.findByIdUsuarioAndEstado(idUsuario, "no_leida");
        for (Notificacion n : pendientes) {
            n.setEstado("leida");
        }
        notificacionRepository.saveAll(pendientes);
    }
}
