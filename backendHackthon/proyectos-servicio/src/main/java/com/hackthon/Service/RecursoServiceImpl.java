package com.hackthon.Service;

import com.hackthon.Entity.Recurso;
import com.hackthon.Repository.RecursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoServiceImpl implements RecursoService {

    private final RecursoRepository recursoRepository;

    public RecursoServiceImpl(RecursoRepository recursoRepository) {
        this.recursoRepository = recursoRepository;
    }

    @Override
    public Recurso crearRecurso(Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    @Override
    public Recurso obtenerRecursoPorId(Long id) {
        return recursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Recurso> obtenerRecursosPorProyecto(Long idProyecto) {
        return recursoRepository.findByIdProyecto(idProyecto);
    }

    @Override
    public Recurso actualizarRecurso(Long id, Recurso recurso) {
        Recurso existente = recursoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(recurso.getNombre());
            existente.setUrl(recurso.getUrl());
            existente.setDescripcion(recurso.getDescripcion());
            return recursoRepository.save(existente);
        }
        return null;
    }

    @Override
    public void eliminarRecurso(Long id) {
        recursoRepository.deleteById(id);
    }
}