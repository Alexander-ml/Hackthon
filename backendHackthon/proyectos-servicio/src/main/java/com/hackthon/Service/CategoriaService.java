package com.hackthon.Service;

import com.hackthon.Entity.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Categoria crearCategoria(Categoria categoria); // Crear nueva categoría

    Categoria actualizarCategoria(Categoria categoria); // Actualizar categoría existente

    void eliminarCategoria(Long id); // Eliminar categoría por ID

    Categoria obtenerPorId(Long id); // Buscar categoría por ID

    List<Categoria> obtenerTodas(); // Obtener todas las categorías

    Optional<Categoria> obtenerPorNombre(String nombre); // Buscar categoría por nombre
}
