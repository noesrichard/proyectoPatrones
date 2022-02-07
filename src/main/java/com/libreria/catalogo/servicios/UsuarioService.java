package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Permiso;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

import java.util.List;

public class UsuarioService implements Servicio<Usuario> {

    Repositorio<Usuario, String> repositorio;

    public UsuarioService(Repositorio<Usuario, String> repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Usuario> listar() {
        return repositorio.listar();
    }

    @Override
    public Usuario buscar(Usuario entidad) {
        return  repositorio.porId(entidad.getUsername());
    }

    @Override
    public Usuario guardar(Usuario entidad) {
        return  repositorio.guardar(entidad);
    }

    @Override
    public Usuario editar(Usuario entidad) {
        return  repositorio.editar(entidad, entidad.getUsername());
    }

    @Override
    public Usuario eliminar(Usuario entidad) {
        return  repositorio.eliminar(entidad.getUsername());
    }

}
