package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.UserDatabase;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

import java.util.List;

public class UsuarioService implements Servicio<UserDatabase> {

    Repositorio repositorio;

    public UsuarioService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<UserDatabase> listar() {
        return repositorio.listar();
    }

    @Override
    public UserDatabase buscar(UserDatabase entidad) {
        return (UserDatabase) repositorio.porId(entidad.getUsername());
    }

    @Override
    public UserDatabase guardar(UserDatabase entidad) {
        return (UserDatabase) repositorio.guardar(entidad);
    }

    @Override
    public UserDatabase editar(UserDatabase entidad) {
        return (UserDatabase) repositorio.editar(entidad, entidad.getUsername());
    }

    @Override
    public UserDatabase eliminar(UserDatabase entidad) {
        return (UserDatabase) repositorio.eliminar(entidad.getUsername());
    }
}
