package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Libro;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Service;

public class LibroService implements Service {

    Repositorio repoLibro;
    public LibroService(Repositorio repoLibro){
        this.repoLibro = repoLibro;
    }

    public void guardar(Libro libro){
        repoLibro.guardar(libro);
    }
}
