package com.libreria.catalogo.entidad.articulo;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.articulo.Articulo;

public class Revista implements Articulo {

    private String id, nombre, edicion;
    private Autor autor;
    private Categoria categoria;

    public Revista(String id, String nombre, String edicion, Autor autor, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.edicion = edicion;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
