package com.hackthon.Service;

import com.hackthon.Entity.Actividad;

import java.util.List;

public interface ActividadService {
    Actividad crearActividad(Actividad actividad); // Crear nueva actividad

    Actividad actualizarActividad(Actividad actividad); // Actualizar actividad existente

    void eliminarActividad(Long id); // Eliminar actividad por ID

    Actividad obtenerPorId(Long id); // Buscar actividad por ID

    List<Actividad> obtenerTodas(); // Obtener todas las actividades

    List<Actividad> obtenerPorUsuario(Long idUsuario); // Obtener actividades de un usuario
}
