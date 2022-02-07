package com.libreria.catalogo.repositorio;

import com.libreria.catalogo.repositorio.MySQL.*;
import com.libreria.compartido.MySQLRepositorio;
import com.libreria.compartido.Conexion;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;

public class MySQLRepoFactory implements RepoFactory{

    public static final int LIBRO = 1, AUTOR = 2, CATEGORIA = 3, INVENTARIO = 4, USUARIO = 5;
    private Conexion con;
    private Connection conexion;

    @Override
    public Repositorio getRepositorio(int repositorio){
        return switch (repositorio) {
            case LIBRO -> new RepoLibro();
            case AUTOR -> new RepoAutor();
            case CATEGORIA -> new RepoCategoria();
            case INVENTARIO -> new RepoInventario();
            case USUARIO -> new RepoUsuario();
            default -> null;
        };
    }
}
