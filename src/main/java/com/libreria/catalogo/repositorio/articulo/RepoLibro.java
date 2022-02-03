package com.libreria.catalogo.repositorio.articulo;


import com.libreria.catalogo.entidad.articulo.Libro;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class RepoLibro implements Repositorio<Libro, String> {

    private Connection conexion;

    public RepoLibro(Connection conexion){
        this.conexion = conexion;
    }

    @Override
    public List<Libro> listar() {
        return null;
    }

    @Override
    public Libro porId(String id) {
        return null;
    }

    @Override
    public Libro crear(Libro entidad) {
        String sql = "INSERT INTO libro(id, nombre, editorial, autor, categoria) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, entidad.getId());
            ps.setString(2, entidad.getNombre());
            ps.setString(3, entidad.getEditorial());
            ps.setString(4, entidad.getAutor().getId());
            ps.setString(5, entidad.getCategoria().getId());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return entidad;
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
