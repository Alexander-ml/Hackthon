package com.hackthon.Repository;

import com.hackthon.Entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    // Buscar actividades por usuario
    List<Actividad> findByIdUsuario(Long idUsuario);

    // Buscar actividades por proyecto
    List<Actividad> findByIdProyecto(Long idProyecto);

    // Buscar actividades activas
    List<Actividad> findByEstado(String estado);

    // Buscar por usuario y estado
    List<Actividad> findByIdUsuarioAndEstado(Long idUsuario, String estado);
}
