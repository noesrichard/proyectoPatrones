package com.libreria.catalogo.repositorio.MySQL;


import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.Libro;
import com.libreria.compartido.MySQLRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoLibro extends MySQLRepositorio<Libro, String> {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        sql="SELECT * FROM libro";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(
                        new Libro(
                                rs.getString("id"),
                                rs.getString("nombre"),
                                rs.getString("editorial"),
                                rs.getString("autor"),
                                rs.getString("categoria")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Libro porId(String id) {
        Libro libro = null;
        sql = "SELECT * FROM libro WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                libro =  new Libro(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("editorial"),
                        rs.getString("autor"),
                        rs.getString("categoria")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }

    @Override
    public Libro guardar(Libro entidad) {
        sql = "INSERT INTO libro (nombre,editorial, autor, categoria)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "SELECT * FROM libro ORDER BY id DESC LIMIT 1";
        Libro libro = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                libro = new Libro(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("editorial"),
                        rs.getString("autor"),
                        rs.getString("categoria")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }

    @Override
    public Libro editar(Libro entidad, String id) {
        sql="UPDATE  libro SET nombre="+entidad.getNombre() +
                ", editorial="+entidad.getEditorial() + ", autor="+entidad.getAutor() +
                ", categoria=" + entidad.getCategoria();
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return porId(id);
    }

    @Override
    public Libro eliminar(String id) {
        Libro libro = porId(id);

        sql ="DELETE FROM libro WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }


}
