package com.hackthon.Service;


import com.hackthon.Entity.Valoracion;

import java.util.List;

public interface ValoracionService {

    Valoracion crearValoracion(Valoracion valoracion);

    Valoracion obtenerValoracionPorId(Long id);

    List<Valoracion> obtenerValoracionesPorProyecto(Long idProyecto);

    void eliminarValoracion(Long id);
}
