package com.libreria.catalogo.entidad.articulo;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.articulo.Articulo;

public class Comic implements Articulo {
    private String id, nombre, numero, volumen;
    private Autor autor;
    private Categoria categoria;

    public Comic(String id, String nombre, String numero, String volumen, Autor autor, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.volumen = volumen;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
