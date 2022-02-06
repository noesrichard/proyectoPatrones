package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Categoria;
import com.libreria.compartido.MySQLRepositorio;

import java.util.List;

public class RepoCategoria extends MySQLRepositorio<Categoria,String> {
    @Override
    public List<Categoria> listar() {
        return null;
    }

    @Override
    public Categoria porId(String id) {
        return null;
    }

    @Override
    public Categoria guardar(Categoria entidad) {
        return null;
    }

    @Override
    public Categoria editar(Categoria entidad, String id) {
        return null;
    }

    @Override
    public Categoria eliminar(String id) {
        return null;
    }


}
