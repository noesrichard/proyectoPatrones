package com.libreria.catalogo.entidad;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public static final String LEER = "LEER", CREAR="CREAR", EDITAR="EDITAR", ELIMINAR="ELIMINAR";

    private static final Usuario usuario = null;

    private String username, password;

    private List<Permiso> permisos = new ArrayList<>();

    private Usuario() {
    }



    private Usuario(Permiso permiso){

        permisos.add(permiso);
    }

    public static Usuario _getUsuario(){
        if(usuario == null) {
            return new Usuario(Permiso.LEER);
        }
        return usuario;
    }

    public boolean tienePermiso(Permiso permiso){
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

    public List<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permiso> permisos) {
        this.permisos = permisos;
    }
}
