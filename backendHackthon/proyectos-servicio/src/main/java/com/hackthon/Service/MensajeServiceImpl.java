package com.hackthon.Service;

import com.hackthon.Entity.Mensaje;
import com.hackthon.Repository.MensajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeServiceImpl implements MensajeService {

    private final MensajeRepository mensajeRepository;

    public MensajeServiceImpl(MensajeRepository mensajeRepository) {
        this.mensajeRepository = mensajeRepository;
    }

    @Override
    public Mensaje enviarMensaje(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    @Override
    public void eliminarMensaje(Long idMensaje) {
        mensajeRepository.deleteById(idMensaje);
    }

    @Override
    public Optional<Mensaje> obtenerPorId(Long idMensaje) {
        return mensajeRepository.findById(idMensaje);
    }

    @Override
    public List<Mensaje> listarMensajesEntreUsuarios(Long idEmisor, Long idReceptor) {
        return mensajeRepository.findByEmisorIdUsuarioAndReceptorIdUsuario(idEmisor, idReceptor);
    }

    @Override
    public List<Mensaje> listarMensajesRecibidos(Long idReceptor) {
        return mensajeRepository.findByIdReceptor(idReceptor);
    }

    @Override
    public List<Mensaje> listarMensajesEnviados(Long idEmisor) {
        return mensajeRepository.findByIdEmisor(idEmisor);
    }

    @Override
    public void marcarComoLeido(Long idMensaje) {
        Optional<Mensaje> mensajeOpt = mensajeRepository.findById(idMensaje);
        if (mensajeOpt.isPresent()) {
            Mensaje mensaje = mensajeOpt.get();
            mensaje.setEstado("leido");
            mensajeRepository.save(mensaje);
        }
    }
}
