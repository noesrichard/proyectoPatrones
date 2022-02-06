package com.libreria.catalogo.proxy;

import com.libreria.catalogo.entidad.Libro;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.catalogo.servicios.LibroService;
import com.libreria.compartido.Service;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxyLibroService implements Service<Libro> {
    private LibroService libroService;
    private Usuario usuario;

    public ProxyLibroService(LibroService libroService, Usuario usuario){
        this.libroService = libroService;
        this.usuario = usuario;
    }
    @Override
    public List<Libro> listar(Libro entidad) {
        if(usuario.checkPermiso(Usuario.LEER)) {
            return libroService.listar(entidad);
        }
        System.out.println("No tiene permisos");
        return new ArrayList<Libro>();
    }

    @Override
    public Libro buscar(Libro entidad) {
        return null;
    }

    @Override
    public Libro guardar(Libro entidad) {
        return null;
    }

    @Override
    public Libro editar(Libro entidad) {
        return null;
    }

    @Override
    public Libro eliminar(Libro entidad) {
        return null;
    }
}
