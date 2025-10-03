package com.hackthon.Repository;

import com.hackthon.Entity.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

    // Traer todos los mensajes enviados por un usuario
    List<Mensaje> findByIdEmisor(Long idEmisor);

    // Traer todos los mensajes recibidos por un usuario
    List<Mensaje> findByIdReceptor(Long idReceptor);

    //
    List<Mensaje> findByEmisorIdUsuarioAndReceptorIdUsuario(Long idEmisor, Long idReceptor);

    // Traer mensajes activos
    List<Mensaje> findByEstado(String estado);
}
