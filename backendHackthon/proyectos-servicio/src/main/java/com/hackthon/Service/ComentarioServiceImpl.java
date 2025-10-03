package com.hackthon.Service;

import com.hackthon.Entity.Comentario;
import com.hackthon.Repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Comentario guardar(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public void eliminar(Long idComentario) {
        comentarioRepository.deleteById(idComentario);
    }

    @Override
    public Optional<Comentario> obtenerPorId(Long idComentario) {
        return comentarioRepository.findById(idComentario);
    }

    @Override
    public List<Comentario> listarTodos() {
        return comentarioRepository.findAll();
    }

    @Override
    public List<Comentario> listarPorProyecto(Long idProyecto) {
        return comentarioRepository.findByIdProyecto(idProyecto);
    }

    @Override
    public List<Comentario> listarPorUsuario(Long idUsuario) {
        return comentarioRepository.findByIdUsuario(idUsuario);
    }
}
