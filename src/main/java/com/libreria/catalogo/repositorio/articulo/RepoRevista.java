package com.libreria.catalogo.repositorio.articulo;

import com.libreria.catalogo.entidad.articulo.Revista;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;
import java.util.List;

public class RepoRevista implements Repositorio<Revista, String> {

    private Connection conexion;

    public RepoRevista(Connection conexion){
        this.conexion = conexion;
    }


    @Override
    public List<Revista> listar() {
        return null;
    }

    @Override
    public Revista porId(String id) {
        return null;
    }

    @Override
    public Revista crear(Revista entidad) {
        return null;
    }

    @Override
    public Revista editar(Revista entidad) {
        return null;
    }

    @Override
    public Revista eliminar(Revista entidad) {
        return null;
    }
}
