package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.compartido.MySQLRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoCategoria extends MySQLRepositorio<Categoria,String> {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Categoria> listar() {
        List<Categoria> lista = new ArrayList<>();
        sql = "SELECT * FROM categoria";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(
                        new Categoria(
                                rs.getString("id"),
                                rs.getString("nombre")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    @Override
    public Categoria porId(String id) {
        sql = "SELECT * FROM categoria WHERE id="+id;
        Categoria categoria = null;

        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                categoria = new Categoria(rs.getString("id"), rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria entidad) {
        sql = "INSERT INTO categoria (nombre) VALUES (?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "SELECT * FROM categoria ORDER BY id DESC LIMIT 1";
        Categoria categoria = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                categoria = new Categoria(
                        rs.getString("id"),
                        rs.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public Categoria editar(Categoria entidad, String id) {
        sql = "UPDATE FROM categoria SET nombre="+entidad.getNombre()+" WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Categoria eliminar(String id) {
        Categoria categoria = porId(id);
        sql = "DELETE FROM categoria WHERE id=" + id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoria;
    }


}
