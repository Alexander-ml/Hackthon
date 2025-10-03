package com.hackthon.Service;

import com.hackthon.Entity.ColaboradorProyecto;
import com.hackthon.Repository.ColaboradorProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorProyectoServiceImpl implements ColaboradorProyectoService {

    private final ColaboradorProyectoRepository colaboradorProyectoRepository;

    public ColaboradorProyectoServiceImpl(ColaboradorProyectoRepository colaboradorProyectoRepository) {
        this.colaboradorProyectoRepository = colaboradorProyectoRepository;
    }

    @Override
    public ColaboradorProyecto guardar(ColaboradorProyecto colaboradorProyecto) { // crear o actualizar un colaborador en un proyecto.
        return colaboradorProyectoRepository.save(colaboradorProyecto);
    }

    @Override
    public void eliminar(Long idColaboradorProyecto) { // borrar al colaborador del proyecto.
        colaboradorProyectoRepository.deleteById(idColaboradorProyecto);
    }

    @Override
    public Optional<ColaboradorProyecto> obtenerPorId(Long idColaboradorProyecto) {
        return colaboradorProyectoRepository.findById(idColaboradorProyecto);
    }

    @Override
    public List<ColaboradorProyecto> listarTodos() { //
        return colaboradorProyectoRepository.findAll();
    }

    @Override
    public List<ColaboradorProyecto> listarPorProyecto(Long idProyecto) { // obtener todos los colaboradores de un proyecto.
        return colaboradorProyectoRepository.findByIdProyecto(idProyecto);
    }

    @Override
    public List<ColaboradorProyecto> listarPorUsuario(Long idUsuario) { // ver en qué proyectos colabora un usuario
        return colaboradorProyectoRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public Optional<ColaboradorProyecto> buscarPorProyectoYUsuario(Long idProyecto, Long idUsuario) {
        return colaboradorProyectoRepository.findByIdProyectoAndIdUsuario(idProyecto, idUsuario); // comprobar si ya está colaborando, esto evita duplicados
    }
}
