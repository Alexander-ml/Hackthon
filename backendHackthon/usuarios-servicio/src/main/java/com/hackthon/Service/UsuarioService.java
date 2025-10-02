package com.hackthon.Service;

import com.hackthon.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarUsuarios();
    Optional<Usuario> buscarPorId(Long idUsuario);
    Optional<Usuario> buscarPorCorreo(String correo);
    Usuario guardarUsuario(Usuario usuario);
    Usuario actualizarUsuario(Long idUsuario, Usuario usuario);
    void eliminarUsuario(Long idUsuario);
}
