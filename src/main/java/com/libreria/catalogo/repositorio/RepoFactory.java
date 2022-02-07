package com.libreria.catalogo.repositorio;

import com.libreria.compartido.Repositorio;

public interface RepoFactory {

    public Repositorio getRepositorio(int repositorio);
}
