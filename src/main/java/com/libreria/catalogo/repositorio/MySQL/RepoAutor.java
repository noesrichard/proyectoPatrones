package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.compartido.MySQLRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoAutor extends MySQLRepositorio<Autor, String> {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public List<Autor> listar() {
        List<Autor> lista = new ArrayList<>();

        sql= "SELECT * FROM autor";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(
                        new Autor(
                                rs.getString("id"),
                                rs.getString("nombre"),
                                rs.getString("apellido")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Autor porId(String id) {
        sql = "SELECT * from autor WHERE id ="+id;
        Autor autor = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                autor = new Autor(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autor;
    }

    @Override
    public Autor guardar(Autor entidad) {
        sql = "INSERT INTO autor (nombre,apellido) VALUES (?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, entidad.getNombre());
            ps.setString(2,entidad.getApellido());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "SELECT * FROM autor ORDER BY id DESC LIMIT 1";
        Autor autor = null;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                autor = new Autor(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autor;
    }

    @Override
    public Autor editar(Autor entidad, String id) {
        sql = "UPDATE INTO autor SET nombre="+entidad.getNombre()+", apellido="+entidad.getApellido()+" WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return porId(id);
    }

    @Override
    public Autor eliminar(String id) {
        Autor autor = porId(id);

        sql="DELETE FROM autor WHERE id="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return autor;
    }


}
