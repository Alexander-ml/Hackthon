package com.hackthon.Repository;

import com.hackthon.Entity.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long> {
    // buscar roles por usuario
}
