package com.libreria.catalogo.repositorio.articulo;

import com.libreria.catalogo.entidad.articulo.Comic;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;
import java.util.List;

public class RepoComic implements Repositorio<Comic, String> {

    private Connection conexion;

    public RepoComic(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public List<Comic> listar() {
        return null;
    }

    @Override
    public Comic porId(String id) {
        return null;
    }

    @Override
    public Comic crear(Comic entidad) {
        return null;
    }

    @Override
    public Comic editar(Comic entidad) {
        return null;
    }

    @Override
    public Comic eliminar(Comic entidad) {
        return null;
    }
}
