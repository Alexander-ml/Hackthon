package com.hackthon.Service;

import com.hackthon.Entity.Valoracion;
import com.hackthon.Repository.ValoracionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionServiceImpl implements ValoracionService {

    private final ValoracionRepository valoracionRepository;

    public ValoracionServiceImpl(ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    @Override
    public Valoracion crearValoracion(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }

    @Override
    public Valoracion obtenerValoracionPorId(Long id) {
        return valoracionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Valoracion> obtenerValoracionesPorProyecto(Long idProyecto) {
        return valoracionRepository.findByIdProyecto(idProyecto);
    }

    @Override
    public void eliminarValoracion(Long id) {
        valoracionRepository.deleteById(id);
    }
}
