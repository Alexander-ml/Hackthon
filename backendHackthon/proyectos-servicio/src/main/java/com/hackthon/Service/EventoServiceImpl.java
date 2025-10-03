package com.hackthon.Service;

import com.hackthon.Entity.Evento;
import com.hackthon.Repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    private final EventoRepository eventoRepository;

    public EventoServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Evento guardar(Evento evento) {
        return eventoRepository.save(evento);
    }

    @Override
    public void eliminar(Long idEvento) {
        eventoRepository.deleteById(idEvento);
    }

    @Override
    public Optional<Evento> obtenerPorId(Long idEvento) {
        return eventoRepository.findById(idEvento);
    }

    @Override
    public List<Evento> listarTodos() {
        return eventoRepository.findAll();
    }

    @Override
    public List<Evento> listarPorCategoria(String categoria) {
        return eventoRepository.findByCategoria(categoria);
    }

    @Override
    public List<Evento> listarPorEstado(String estado) {
        return eventoRepository.findByEstado(estado);
    }

    @Override
    public List<Evento> listarProximos() {
        return eventoRepository.findByFechaInicioAfter(LocalDateTime.now());
    }
}
