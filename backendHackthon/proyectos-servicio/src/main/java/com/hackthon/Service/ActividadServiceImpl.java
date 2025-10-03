package com.hackthon.Service;

import com.hackthon.Entity.Actividad;
import com.hackthon.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired // inyecta el ActividadRepository automáticamente
    private ActividadRepository actividadRepository;

    @Override
    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    @Override
    public Actividad actualizarActividad(Actividad actividad) { // spring entiende que si ya existe ese id realiza un update
        return actividadRepository.save(actividad);
    }

    @Override
    public void eliminarActividad(Long id) {
        actividadRepository.deleteById(id);
    }

    @Override
    public Actividad obtenerPorId(Long id) {
        Optional<Actividad> opcional = actividadRepository.findById(id);
        return opcional.orElse(null); // devuelve null si no lo encuentra
    }

    @Override
    public List<Actividad> obtenerTodas() {
        return actividadRepository.findAll();
    }

    @Override
    public List<Actividad> obtenerPorUsuario(Long idUsuario) {
        return actividadRepository.findByIdUsuario(idUsuario);
    }
}
