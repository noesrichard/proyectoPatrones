package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Usuario;
import com.libreria.compartido.MySQLRepositorio;

import java.util.List;

public class UsuarioRepo extends MySQLRepositorio<Usuario, String> {
    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario porId(String id) {
        return null;
    }

    @Override
    public Usuario guardar(Usuario entidad) {
        return null;
    }

    @Override
    public Usuario editar(Usuario entidad) {
        return null;
    }

    @Override
    public Usuario eliminar(Usuario entidad) {
        return null;
    }
}
