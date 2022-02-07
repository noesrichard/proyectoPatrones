package com.libreria.catalogo.repositorio.MySQL;


import com.libreria.catalogo.entidad.Autor;
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
        sql="select l.*,a.nombre as nombre_autor, a.apellido as apellido_autor,c.nombre as nombre_categoria from libro l, autor a, categoria c where a.id = l.autor and c.id = l.categoria";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(
                        new Libro(
                                rs.getString("id"),
                                rs.getString("nombre"),
                                rs.getString("editorial"),
                                new Autor( rs.getString("autor"),
                                           rs.getString("nombre_autor"),
                                           rs.getString("apellido_autor")
                                          ),
                                new Categoria(rs.getString("categoria"),
                                        rs.getString("nombre_categoria"))
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
        Autor autor = null;
        Categoria categoria = null;
        sql = "select l.*,a.nombre as nombre_autor, a.apellido as apellido_autor,c.nombre as nombre_categoria from libro l, autor a, categoria c where a.id = l.autor and c.id = l.categoria and l.id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                autor = new Autor(
                        rs.getString("autor"),
                        rs.getString("nombre_autor"),
                        rs.getString("apellido_autor")
                        );
                categoria = new Categoria(
                        rs.getString("categoria"),
                        rs.getString("nombre_categoria")
                        );
                libro =  new Libro(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("editorial"),
                        autor,
                        categoria
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return libro;
    }

    @Override
    public Libro guardar(Libro entidad) {
        sql = "INSERT INTO libro (nombre,editorial, autor, categoria) values(?,?,?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2, entidad.getEditorial());
            ps.setString(3, entidad.getAutor().getId());
            ps.setString(4, entidad.getCategoria().getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "select l.*,a.nombre as nombre_autor, a.apellido as apellido_autor,c.nombre as nombre_categoria from libro l, autor a, categoria c where a.id = l.autor and c.id = l.categoria order by id desc limit 1";
        Libro libro = null;
        Autor autor = null;
        Categoria categoria = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                autor = new Autor(
                        rs.getString("autor"),
                        rs.getString("nombre_autor"),
                        rs.getString("apellido_autor")
                        );
                categoria = new Categoria(
                        rs.getString("categoria"),
                        rs.getString("nombre_categoria")
                        );
                libro =  new Libro(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("editorial"),
                        autor,
                        categoria
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libro;
    }

    @Override
    public Libro editar(Libro entidad, String id) {
        sql="UPDATE  libro SET nombre='"+entidad.getNombre() +
                "', editorial='"+entidad.getEditorial() + "', autor="+entidad.getAutor().getId() +
                ", categoria=" + entidad.getCategoria().getId()+
                " where id="+id;
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
