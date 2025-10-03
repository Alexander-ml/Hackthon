package com.hackthon.Repository;

import com.hackthon.Entity.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Long> {

    // Traer oportunidades por tipo
    List<Oportunidad> findByTipo(String tipo);

    // Traer oportunidades activas
    List<Oportunidad> findByEstado(String estado);

    // Buscar oportunidades por categoría
    List<Oportunidad> findByCategoria(String categoria);
}
