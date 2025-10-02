package com.hackthon.Controller;

import com.hackthon.Entity.Rol;
import com.hackthon.Service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {
    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    // GET, listar roles
    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.listarRoles();
    }

    // POST, crear rol
    @PostMapping
    public ResponseEntity<Rol> guardarRol(@RequestBody Rol rol) {
        Rol nuevoRol = rolService.guardarRol(rol);
        return ResponseEntity.ok(nuevoRol);
    }
}
