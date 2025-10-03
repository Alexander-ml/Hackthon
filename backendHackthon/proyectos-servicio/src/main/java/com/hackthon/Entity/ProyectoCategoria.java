package com.hackthon.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proyecto_categoria")
public class ProyectoCategoria {

    @EmbeddedId
    private ProyectoCategoriaId id;

    @ManyToOne
    @MapsId("idProyecto") // Conecta con la clave compuesta
    @JoinColumn(name = "id_proyecto")
    private Proyecto proyecto;

    @ManyToOne
    @MapsId("idCategoria") // Conecta con la clave compuesta
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    public ProyectoCategoria() {}

    public ProyectoCategoria(Proyecto proyecto, Categoria categoria) {
        this.proyecto = proyecto;
        this.categoria = categoria;
        this.id = new ProyectoCategoriaId(proyecto.getIdProyecto(), categoria.getIdCategoria());
    }

    // Getters & Setters
    public ProyectoCategoriaId getId() {
        return id;
    }

    public void setId(ProyectoCategoriaId id) {
        this.id = id;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
