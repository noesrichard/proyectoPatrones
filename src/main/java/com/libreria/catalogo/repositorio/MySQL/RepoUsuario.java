package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.catalogo.entidad.Permiso;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.compartido.MySQLRepositorio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepoUsuario extends MySQLRepositorio<Usuario, String> {

    private String sql;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        sql="SELECT * FROM usuario";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Usuario user = new Usuario(rs.getString("username"), rs.getString("password"));
                user.setPermisos(getPermisosUsuario(user.getUsername()));
                lista.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Usuario porId(String id) {
        Usuario user = null;
        sql="SELECT username,password from usuario WHERE username='"+id+"'";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new Usuario(rs.getString("username"), rs.getString("password"));
                user.setPermisos(getPermisosUsuario(user.getUsername()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Usuario guardar(Usuario entidad) {
        sql = "INSERT INTO usuario (username, password) VALUES(?,?)";
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entidad;
    }

    @Override
    public Usuario editar(Usuario entidad, String id) {
        sql = "UPDATE usuario SET password="+entidad.getPassword()+" WHERE username='"+id+"'";
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return porId(id);
    }

    @Override
    public Usuario eliminar(String id) {
        Usuario user = porId(id);
        sql = "DELETE FROM usuario WHERE username='"+id+"'";
        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private List<Permiso> getPermisosUsuario(String username){
        List<Permiso> permisos = new ArrayList<Permiso>();
        sql="SELECT rol from roles_usuario WHERE usuario='"+username+"'";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                permisos.add(Permiso.getById(rs.getInt("rol")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return permisos;
    }

}
