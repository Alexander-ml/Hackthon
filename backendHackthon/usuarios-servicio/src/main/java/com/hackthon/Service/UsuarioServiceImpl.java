package com.hackthon.Service;

import com.hackthon.Entity.Usuario;
import com.hackthon.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        // verificamos si existe el usuario
        if(usuarioRepository.existsByCorreo(usuario.getCorreo())){
           throw new RuntimeException("El correo ya esta registrado");
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long idUsuario, Usuario usuario) {
        return usuarioRepository.findById(idUsuario)
                .map(existente -> {
                    existente.setNombres(usuario.getNombres());
                    existente.setCorreo(usuario.getCorreo());
                    existente.setContrasena(usuario.getContrasena());
                    existente.setCarrera(usuario.getCarrera());
                    existente.setIntereses(usuario.getIntereses());
                    existente.setEstado(usuario.getEstado());
                    return usuarioRepository.save(existente);
                })
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + idUsuario));
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        if (!usuarioRepository.existsById(idUsuario)){
            throw new RuntimeException("No existe un usuario con id: " + idUsuario);
        }
        usuarioRepository.deleteById(idUsuario);
    }


}
