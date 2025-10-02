package com.hackthon.Service;

import com.hackthon.Entity.Rol;

import java.util.List;

public interface RolService {
    List<Rol> listarRoles();
    Rol guardarRol(Rol rol);
}
