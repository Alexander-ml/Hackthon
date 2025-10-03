package com.hackthon.Repository;

import com.hackthon.Entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    // Buscar eventos por estado (por ejemplo: 'proximo', 'finalizado')
    List<Evento> findByEstado(String estado);

    // Buscar eventos por categoría
    List<Evento> findByCategoria(String categoria);

    // Buscar eventos futuros.
    List<Evento> findByFechaInicioAfter(LocalDateTime fecha);
}
