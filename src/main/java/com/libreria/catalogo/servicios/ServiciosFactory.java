package com.libreria.catalogo.servicios;

import com.libreria.catalogo.repositorio.RepoFactory;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

public class ServiciosFactory {
    public static final int LIBRO = 1, AUTOR = 2, CATEGORIA = 3, INVENTARIO = 4, USUARIO = 5;
    private final RepoFactory repoFactory;

    public ServiciosFactory(RepoFactory repoFactory){
       this.repoFactory = repoFactory;
    }

    public Servicio getServicio(int servicio){
        Repositorio repo = repoFactory.getRepositorio(servicio);
        return switch (servicio) {
            case LIBRO -> new LibroService(repo);
            case AUTOR -> new AutorService(repo);
            case CATEGORIA -> new CategoriaService(repo);
            case INVENTARIO -> new InventarioService(repo);
            case USUARIO -> new UsuarioService(repo);
            default -> null;
        };
    }
}
