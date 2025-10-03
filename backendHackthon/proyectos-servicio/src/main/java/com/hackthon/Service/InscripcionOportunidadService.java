package com.hackthon.Service;

import com.hackthon.Entity.InscripcionOportunidad;

import java.util.List;
import java.util.Optional;

public interface InscripcionOportunidadService {

    InscripcionOportunidad guardar(InscripcionOportunidad inscripcion);

    void eliminar(Long idInscripcion);

    Optional<InscripcionOportunidad> obtenerPorId(Long idInscripcion);

    List<InscripcionOportunidad> listarTodas();

    List<InscripcionOportunidad> listarPorUsuario(Long idUsuario);

    List<InscripcionOportunidad> listarPorOportunidad(Long idOportunidad);

    Optional<InscripcionOportunidad> obtenerPorUsuarioYOportunidad(Long idUsuario, Long idOportunidad);
}
