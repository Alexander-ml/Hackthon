package com.hackthon.Entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProyectoCategoriaId implements Serializable {

    private Long idProyecto;
    private Long idCategoria;

    // Constructor vacío para JPA
    public ProyectoCategoriaId() {}

    // Constructor con parámetros
    public ProyectoCategoriaId(Long idProyecto, Long idCategoria) {
        this.idProyecto = idProyecto;
        this.idCategoria = idCategoria;
    }

    // Getters & Setters
    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    // equals y hashCode (OBLIGATORIOS para claves compuestas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProyectoCategoriaId)) return false;
        ProyectoCategoriaId that = (ProyectoCategoriaId) o;
        return Objects.equals(idProyecto, that.idProyecto) &&
                Objects.equals(idCategoria, that.idCategoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProyecto, idCategoria);
    }
}