package com.hackthon.Repository;

import com.hackthon.Entity.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    // Traer todas las notificaciones de un usuario
    List<Notificacion> findByIdUsuario(Long idUsuario);

    // Traer todas las notificaciones no leídas
    List<Notificacion> findByIdUsuarioAndEstado(Long idUsuario, String estado);
}
