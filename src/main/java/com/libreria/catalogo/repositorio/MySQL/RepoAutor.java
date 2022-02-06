package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.compartido.MySQLRepositorio;

import java.util.List;

public class RepoAutor extends MySQLRepositorio<Autor, String> {

    @Override
    public List<Autor> listar() {
        return null;
    }

    @Override
    public Autor porId(String id) {
        return null;
    }

    @Override
    public Autor guardar(Autor entidad) {
        return null;
    }

    @Override
    public Autor editar(Autor entidad) {
        return null;
    }

    @Override
    public Autor eliminar(Autor entidad) {
        return null;
    }
}
