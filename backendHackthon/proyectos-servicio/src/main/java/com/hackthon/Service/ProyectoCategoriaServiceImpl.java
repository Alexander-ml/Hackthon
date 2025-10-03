package com.hackthon.Service;

import com.hackthon.Entity.*;
import com.hackthon.Repository.CategoriaRepository;
import com.hackthon.Repository.ProyectoCategoriaRepository;
import com.hackthon.Repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoCategoriaServiceImpl implements ProyectoCategoriaService {

    private final ProyectoCategoriaRepository proyectoCategoriaRepository;
    private final ProyectoRepository proyectoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProyectoCategoriaServiceImpl(ProyectoCategoriaRepository proyectoCategoriaRepository,
                                        ProyectoRepository proyectoRepository,
                                        CategoriaRepository categoriaRepository) {
        this.proyectoCategoriaRepository = proyectoCategoriaRepository;
        this.proyectoRepository = proyectoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ProyectoCategoria asignarCategoriaAProyecto(Long idProyecto, Long idCategoria) {
        Proyecto proyecto = proyectoRepository.findById(idProyecto)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        Categoria categoria = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        ProyectoCategoria proyectoCategoria = new ProyectoCategoria(proyecto, categoria);
        return proyectoCategoriaRepository.save(proyectoCategoria);
    }

    @Override
    public void eliminarCategoriaDeProyecto(Long idProyecto, Long idCategoria) {
        ProyectoCategoriaId id = new ProyectoCategoriaId(idProyecto, idCategoria);
        proyectoCategoriaRepository.deleteById(id);
    }

    @Override
    public List<ProyectoCategoria> listarCategoriasPorProyecto(Long idProyecto) {
        return proyectoCategoriaRepository.findByIdProyecto(idProyecto);
    }

    @Override
    public List<ProyectoCategoria> listarProyectosPorCategoria(Long idCategoria) {
        return proyectoCategoriaRepository.findByIdCategoria(idCategoria);
    }
}
