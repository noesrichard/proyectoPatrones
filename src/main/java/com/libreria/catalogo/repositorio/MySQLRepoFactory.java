package com.libreria.catalogo.repositorio;

import com.libreria.catalogo.repositorio.MySQL.MySQLRepositorio;
import com.libreria.catalogo.repositorio.MySQL.RepoAutor;
import com.libreria.catalogo.repositorio.MySQL.RepoLibro;
import com.libreria.compartido.Conexion;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class MySQLRepoFactory {

    public static final int LIBRO = 1, AUTOR = 2, CATEGORIA = 3;
    private Conexion con;
    private Connection conexion;

    public MySQLRepositorio getRepositorio(int repositorio){
        switch (repositorio) {
            case LIBRO:
                return new RepoLibro();
            case AUTOR:
                return new RepoAutor();
            default:
                return null;
        }
    }
}
