package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

import java.util.List;

public class AutorService implements Servicio<Autor> {

    private Repositorio repositorio;

    public AutorService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Autor> listar() {
        return repositorio.listar();
    }

    @Override
    public Autor buscar(Autor entidad) {
        return (Autor) repositorio.porId(entidad.getId());
    }

    @Override
    public Autor guardar(Autor entidad) {
        return (Autor) repositorio.guardar(entidad);
    }

    @Override
    public Autor editar(Autor entidad) {
        return (Autor) repositorio.editar(entidad, entidad.getId());
    }

    @Override
    public Autor eliminar(Autor entidad) {
        return (Autor) repositorio.eliminar(entidad.getId());
    }
}
