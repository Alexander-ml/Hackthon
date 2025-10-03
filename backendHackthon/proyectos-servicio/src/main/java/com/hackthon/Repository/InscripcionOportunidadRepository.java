package com.hackthon.Repository;

import com.hackthon.Entity.InscripcionOportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscripcionOportunidadRepository extends JpaRepository<InscripcionOportunidad, Long> {

    // Buscar todas las inscripciones de un usuario
    List<InscripcionOportunidad> findByIdUsuario(Long idUsuario);

    // Buscar todas las inscripciones de una oportunidad
    List<InscripcionOportunidad> findByIdOportunidad(Long idOportunidad);

    // Buscar inscripción específica de un usuario a una oportunidad
    Optional<InscripcionOportunidad> findByIdUsuarioAndIdOportunidad(Long idUsuario, Long idOportunidad);

    // Buscar inscripciones activas
    List<InscripcionOportunidad> findByEstado(String estado);
}
