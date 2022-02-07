package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Libro;
import com.libreria.catalogo.entidad.UserDatabase;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.compartido.MySQLRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo extends MySQLRepositorio<UserDatabase, String> {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<UserDatabase> listar() {
        List<UserDatabase> lista = new ArrayList<>();
        sql="SELECT * FROM usuario";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                lista.add(
                        new UserDatabase(rs.getString("usuario"), rs.getString("password"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public UserDatabase porId(String id) {
        UserDatabase user = null;
        sql="SELECT * from usuario WHERE usuario="+id;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new UserDatabase(rs.getString("usuario"), rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public UserDatabase guardar(UserDatabase entidad) {
        sql = "INSERT INTO usuario (usuario, password) VALUES(?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entidad;
    }

    @Override
    public UserDatabase editar(UserDatabase entidad, String id) {
        sql = "UPDATE usuario SET password="+entidad.getPassword()+" WHERE username="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return porId(id);
    }

    @Override
    public UserDatabase eliminar(String id) {
        UserDatabase user = porId(id);
        sql = "DELETE FROM usuario WHERE username="+id;
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


}
