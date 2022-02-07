package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.Inventario;
import com.libreria.catalogo.entidad.Libro;
import com.libreria.compartido.MySQLRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoInventario extends MySQLRepositorio<Inventario, String> {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<Inventario> listar() {
        List<Inventario> lista = new ArrayList<>();
        sql = "select i.id as id_inventario, i.prestado as prestado, l.*,a.nombre as nombre_autor, a.apellido as apellido_autor,c.nombre as nombre_categoria from inventario i, libro l, autor a, categoria c where i.libro = l.id and a.id = l.autor and c.id = l.categoria";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(
                        new Inventario(
                                rs.getString("id_inventario"),
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
                                ),
                                rs.getString("prestado")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Inventario porId(String id) {
        Inventario inventario = null;
        sql = "select i.id as id_inventario, i.prestado as prestado, l.*,a.nombre as nombre_autor, a.apellido as apellido_autor,c.nombre as nombre_categoria from inventario i, libro l, autor a, categoria c where i.libro = l.id and a.id = l.autor and c.id = l.categoria and i.id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                inventario = new Inventario( rs.getString("id_inventario"),
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
                                ),
                        rs.getString("prestado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inventario;
    }

    @Override
    public Inventario guardar(Inventario entidad) {
        sql = "INSERT INTO inventario (libro,prestado) VALUES (?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, entidad.getLibro().getId());
            ps.setString(2,entidad.getPrestado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "select i.id as id_inventario, i.prestado as prestado, l.*,a.nombre as nombre_autor, a.apellido as apellido_autor,c.nombre as nombre_categoria from inventario i, libro l, autor a, categoria c where i.libro = l.id and a.id = l.autor and c.id = l.categoria ORDER BY i.id DESC LIMIT 1";
        Inventario inventario = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                inventario = new Inventario( rs.getString("id"),
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
                                ),
                        rs.getString("prestado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventario;
    }

    @Override
    public Inventario editar(Inventario entidad, String id) {
       sql = "UPDATE inventario SET libro="+entidad.getLibro().getId() + ", prestado='"+entidad.getPrestado()+"' WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return porId(id);
    }

    @Override
    public Inventario eliminar(String id) {
        Inventario inventario = porId(id);
        sql = "DELETE FROM inventario WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventario;
    }
}
