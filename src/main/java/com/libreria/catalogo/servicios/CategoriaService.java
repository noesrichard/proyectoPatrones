package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Categoria;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

import java.util.List;

public class CategoriaService implements Servicio<Categoria> {

    private Repositorio repositorio;

     public CategoriaService(Repositorio repositorio){
         this.repositorio=repositorio;
     }

    @Override
    public List<Categoria> listar() {
        return repositorio.listar();
    }

    @Override
    public Categoria buscar(Categoria entidad) {
        return (Categoria) repositorio.porId(entidad.getId());
    }

    @Override
    public Categoria guardar(Categoria entidad) {
        return (Categoria) repositorio.guardar(entidad);
    }

    @Override
    public Categoria editar(Categoria entidad) {
        return (Categoria) repositorio.editar(entidad, entidad.getId());
    }

    @Override
    public Categoria eliminar(Categoria entidad) {
        return (Categoria) repositorio.eliminar(entidad.getId());
    }
}
