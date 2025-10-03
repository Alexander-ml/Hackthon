package com.hackthon.Service;

import com.hackthon.Entity.Oportunidad;
import com.hackthon.Repository.OportunidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OportunidadServiceImpl implements OportunidadService {

    private final OportunidadRepository oportunidadRepository;

    public OportunidadServiceImpl(OportunidadRepository oportunidadRepository) {
        this.oportunidadRepository = oportunidadRepository;
    }

    @Override
    public Oportunidad crearOportunidad(Oportunidad oportunidad) {
        return oportunidadRepository.save(oportunidad);
    }

    @Override
    public Oportunidad actualizarOportunidad(Long idOportunidad, Oportunidad oportunidad) {
        return oportunidadRepository.findById(idOportunidad).map(o -> {
            o.setTipo(oportunidad.getTipo());
            o.setTitulo(oportunidad.getTitulo());
            o.setDescripcion(oportunidad.getDescripcion());
            o.setFechaInicio(oportunidad.getFechaInicio());
            o.setFechaFin(oportunidad.getFechaFin());
            o.setCategoria(oportunidad.getCategoria());
            o.setEstado(oportunidad.getEstado());
            return oportunidadRepository.save(o);
        }).orElseThrow(() -> new RuntimeException("Oportunidad no encontrada con id " + idOportunidad));
    }

    @Override
    public void eliminarOportunidad(Long idOportunidad) {
        oportunidadRepository.deleteById(idOportunidad);
    }

    @Override
    public Optional<Oportunidad> obtenerPorId(Long idOportunidad) {
        return oportunidadRepository.findById(idOportunidad);
    }

    @Override
    public List<Oportunidad> listarTodas() { // lista todas las oportunidades
        return oportunidadRepository.findAll();
    }

    @Override
    public List<Oportunidad> listarPorCategoria(String categoria) { // lista por categoria las oportunidaddes
        return oportunidadRepository.findByCategoria(categoria);
    }

    @Override
    public List<Oportunidad> listarPorEstado(String estado) {
        return oportunidadRepository.findByEstado(estado);
    }

    @Override
    public List<Oportunidad> listarPorTipo(String tipo) {
        return oportunidadRepository.findByTipo(tipo);
    }

    @Override
    public List<Oportunidad> listarActivas() {
        return oportunidadRepository.findByEstado("activa");
    }
}