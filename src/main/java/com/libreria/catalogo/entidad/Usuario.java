package com.libreria.catalogo.entidad;

import java.util.List;

public class Usuario {

    public static final String LEER = "LEER", CREAR="CREAR", EDITAR="EDITAR", ELIMINAR="ELIMINAR";

    public static final Usuario usuario = null;

    private String username, password;

    private List<String> permisos;

    private Usuario() {
    }

    public Usuario getUsuario(){
        if(usuario == null) {
            return new Usuario();
        }
        return usuario;
    }

    public boolean checkPermiso(String permiso){
        return permisos.contains(permiso);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<String> permisos) {
        this.permisos = permisos;
    }
}
