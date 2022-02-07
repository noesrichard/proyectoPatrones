package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.Inventario;
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
        sql = "SELECT * FROM inventario";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(
                        new Inventario(
                                rs.getString("id"),
                                rs.getString("libro"),
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
        sql = "SELECT * FROM inventario WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                inventario = new Inventario( rs.getString("id"),
                        rs.getString("libro"),
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
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        sql = "SELECT * FROM inventario ORDER BY id DESC LIMIT 1";
        Inventario inventario = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                inventario = new Inventario( rs.getString("id"),
                        rs.getString("libro"),
                        rs.getString("prestado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventario;
    }

    @Override
    public Inventario editar(Inventario entidad, String id) {
       sql = "UPDATE inventario SET libro="+entidad.getLibro() + ", prestado="+entidad.getPrestado()+" WHERE id="+id;
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
