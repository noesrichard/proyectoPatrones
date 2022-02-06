package com.libreria.catalogo.entidad;

import java.util.List;

public class Usuario {

    private String username, password;

    private List<String> permisos;

    public Usuario() {
    }

    public Usuario(String username, String password, List<String> permisos) {
        this.username = username;
        this.password = password;
        this.permisos = permisos;
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
