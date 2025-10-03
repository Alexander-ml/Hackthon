package com.hackthon.Repository;

import com.hackthon.Entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Buscar categoría por nombre, para validar duplicados o buscar
    Optional<Categoria> findByNombre(String nombre);

    // Verificar existencia por nombre
    boolean existsByNombre(String nombre);
}
