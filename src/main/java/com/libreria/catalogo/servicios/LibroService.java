package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Libro;
import com.libreria.compartido.Repositorio;

public class LibroService {

    Repositorio repoLibro;
    public LibroService(Repositorio repoLibro){
        this.repoLibro = repoLibro;
    }

    public void guardar(Libro libro){
        repoLibro.guardar(libro);
    }
}
