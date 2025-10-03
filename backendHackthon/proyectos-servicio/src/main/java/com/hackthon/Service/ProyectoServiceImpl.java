package com.hackthon.Service;

import com.hackthon.Entity.Proyecto;
import com.hackthon.Repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public Proyecto crearProyecto(Proyecto proyecto) {
        proyecto.setFechaCreacion(LocalDateTime.now());
        proyecto.setFechaActualizacion(LocalDateTime.now());
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto actualizarProyecto(Long idProyecto, Proyecto proyecto) {
        return proyectoRepository.findById(idProyecto).map(p -> {
            p.setTitulo(proyecto.getTitulo());
            p.setDescripcion(proyecto.getDescripcion());
            p.setEstado(proyecto.getEstado());
            p.setTipo(proyecto.getTipo());
            p.setFechaActualizacion(LocalDateTime.now());
            return proyectoRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Proyecto no encontrado con id " + idProyecto));
    }

    @Override
    public void eliminarProyecto(Long idProyecto) {
        proyectoRepository.deleteById(idProyecto);
    }

    @Override
    public Optional<Proyecto> obtenerPorId(Long idProyecto) {
        return proyectoRepository.findById(idProyecto);
    }

    @Override
    public List<Proyecto> listarTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public List<Proyecto> listarPorUsuario(Long idUsuario) {
        return proyectoRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<Proyecto> listarPorCategoria(String categoria) {
        return proyectoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Proyecto> listarPorEstado(String estado) {
        return proyectoRepository.findByEstado(estado);
    }

    @Override
    public List<Proyecto> listarPorTipo(String tipo) {
        return proyectoRepository.findByTipo(tipo);
    }
}
