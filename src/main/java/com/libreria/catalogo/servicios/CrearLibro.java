package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.articulo.Libro;
import com.libreria.compartido.Repositorio;

public class CrearLibro {

    Repositorio repoLibro;
    public CrearLibro(Repositorio repoLibro){
        this.repoLibro = repoLibro;
    }

    public void execute(Libro libro){
        repoLibro.crear(libro);
    }
}
