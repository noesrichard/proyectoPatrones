package com.libreria.catalogo.repositorio.MySQL;


import com.libreria.catalogo.entidad.Libro;
import com.libreria.compartido.MySQLRepositorio;

import java.util.List;

public class RepoLibro extends MySQLRepositorio<Libro, String> {

    @Override
    public List<Libro> listar() {
        return null;
    }

    @Override
    public Libro porId(String id) {
        return null;
    }

    @Override
    public Libro guardar(Libro entidad) {
        return null;
    }

    @Override
    public Libro editar(Libro entidad, String id) {
        return null;
    }

    @Override
    public Libro eliminar(String id) {
        return null;
    }


}
