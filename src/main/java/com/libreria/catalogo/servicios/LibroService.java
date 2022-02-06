package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Libro;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

import java.util.List;

public class LibroService implements Servicio<Libro> {

    Repositorio repoLibro;
    public LibroService(Repositorio repoLibro){
        this.repoLibro = repoLibro;
    }

    @Override
    public List<Libro> listar(Libro entidad) {
        return null;
    }

    @Override
    public Libro buscar(Libro entidad) {
        return null;
    }

    @Override
    public Libro guardar(Libro entidad) {
        return null;
    }

    @Override
    public Libro editar(Libro entidad) {
        return null;
    }

    @Override
    public Libro eliminar(Libro entidad) {
        return null;
    }
}
