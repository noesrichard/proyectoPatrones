package com.libreria.catalogo.entidad;

import java.util.ArrayList;
import java.util.List;

public class UsuarioLoggeado extends Usuario{

    private static final UsuarioLoggeado usuario = null;

    private UsuarioLoggeado() {
        super();
    }

    private UsuarioLoggeado(Permiso permiso){
        super();
        permisos.add(permiso);
    }

    public static UsuarioLoggeado _getUsuario(){
        if(usuario == null) {
            return new UsuarioLoggeado(Permiso.LEER);
        }
        return usuario;
    }

    public boolean tienePermiso(Permiso permiso){
        return permisos.contains(permiso);
    }

}
