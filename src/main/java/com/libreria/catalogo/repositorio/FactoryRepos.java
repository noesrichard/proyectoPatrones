package com.libreria.catalogo.repositorio;

import com.libreria.catalogo.repositorio.articulo.RepoComic;
import com.libreria.catalogo.repositorio.articulo.RepoLibro;
import com.libreria.catalogo.repositorio.articulo.RepoRevista;
import com.libreria.compartido.Conexion;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;

public class FactoryRepos {

    public static final int LIBRO = 1, COMIC = 2, REVISTA = 3;
    private Conexion con;
    private Connection conexion;

    public FactoryRepos(){
        con = Conexion._getConexion();
        conexion = con.getCon();
    }
    public Repositorio getRepositorio(int repositorio){
        switch (repositorio) {
            case LIBRO:
                return new RepoLibro(conexion);
            case COMIC:
                return new RepoComic(conexion);
            case REVISTA:
                return new RepoRevista(conexion);
            default:
                return null;
        }
    }
}
