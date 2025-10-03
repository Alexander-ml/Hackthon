package com.hackthon.Service;

import com.hackthon.Entity.Oportunidad;

import java.util.List;
import java.util.Optional;

public interface OportunidadService {

    Oportunidad crearOportunidad(Oportunidad oportunidad);

    Oportunidad actualizarOportunidad(Long idOportunidad, Oportunidad oportunidad);

    void eliminarOportunidad(Long idOportunidad);

    Optional<Oportunidad> obtenerPorId(Long idOportunidad);

    List<Oportunidad> listarTodas();

    List<Oportunidad> listarPorCategoria(String categoria);

    List<Oportunidad> listarPorEstado(String estado);

    List<Oportunidad> listarPorTipo(String tipo);

    List<Oportunidad> listarActivas();
}
