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
    public List<Libro> listar() {
        return repoLibro.listar();
    }

    @Override
    public Libro buscar(Libro entidad) {
        return (Libro) repoLibro.porId(entidad.getId());
    }

    @Override
    public Libro guardar(Libro entidad) {
        return (Libro) repoLibro.guardar(entidad);
    }

    @Override
    public Libro editar(Libro entidad) {
        return (Libro) repoLibro.editar(entidad, entidad.getId());
    }

    @Override
    public Libro eliminar(Libro entidad) {
        return (Libro) repoLibro.eliminar(entidad.getId());
    }
}
