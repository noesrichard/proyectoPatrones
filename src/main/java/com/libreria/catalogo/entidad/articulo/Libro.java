package com.libreria.catalogo.entidad.articulo;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.articulo.Articulo;

public class Libro implements Articulo {
    private String id, nombre, editorial;
    private Autor autor;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Libro(String id, String nombre, String editorial, Autor autor, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
