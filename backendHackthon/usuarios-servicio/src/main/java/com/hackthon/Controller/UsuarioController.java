package com.hackthon.Controller;

import com.hackthon.Entity.Usuario;
import com.hackthon.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios") // define la ruta base todos los endpoints van a empiezan con /api/usuarios
public class UsuarioController {
    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.listarUsuarios();
    }

    // GET, buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long idUsuario){
        return usuarioService.buscarPorId(idUsuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // GET, buscar por correo
    @GetMapping("/correo/{correo}")
    public ResponseEntity<Usuario> buscarPorEmail(@PathVariable String correo) {
        return usuarioService.buscarPorCorreo(correo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //POST, crear usuario
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevo);
    }

    // PUT, actualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            Usuario actualizado = usuarioService.actualizarUsuario(id, usuario);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE, eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        try {
            usuarioService.eliminarUsuario(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
