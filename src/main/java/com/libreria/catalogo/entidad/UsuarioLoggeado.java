package com.libreria.catalogo.entidad;

import java.util.ArrayList;
import java.util.List;

public class UsuarioLoggeado extends Usuario{

    private static UsuarioLoggeado usuario = null;

    private UsuarioLoggeado() {
        super();
    }


    public static UsuarioLoggeado _getUsuario(){
        if(usuario == null) {
            usuario = new UsuarioLoggeado();
        }
        return usuario;
    }


}
