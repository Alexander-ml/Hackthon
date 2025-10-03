package com.hackthon.Service;

import com.hackthon.Entity.InscripcionOportunidad;
import com.hackthon.Repository.InscripcionOportunidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionOportunidadServiceImpl implements InscripcionOportunidadService {

    private final InscripcionOportunidadRepository inscripcionRepository;

    public InscripcionOportunidadServiceImpl(InscripcionOportunidadRepository inscripcionRepository) {
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public InscripcionOportunidad guardar(InscripcionOportunidad inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public void eliminar(Long idInscripcion) {
        inscripcionRepository.deleteById(idInscripcion);
    }

    @Override
    public Optional<InscripcionOportunidad> obtenerPorId(Long idInscripcion) {
        return inscripcionRepository.findById(idInscripcion);
    }

    @Override
    public List<InscripcionOportunidad> listarTodas() {
        return inscripcionRepository.findAll();
    }

    @Override
    public List<InscripcionOportunidad> listarPorUsuario(Long idUsuario) {
        return inscripcionRepository.findByIdUsuario(idUsuario);
    }

    @Override
    public List<InscripcionOportunidad> listarPorOportunidad(Long idOportunidad) {
        return inscripcionRepository.findByIdOportunidad(idOportunidad);
    }

    @Override
    public Optional<InscripcionOportunidad> obtenerPorUsuarioYOportunidad(Long idUsuario, Long idOportunidad) {
        return inscripcionRepository.findByIdUsuarioAndIdOportunidad(idUsuario, idOportunidad);
    }
}
