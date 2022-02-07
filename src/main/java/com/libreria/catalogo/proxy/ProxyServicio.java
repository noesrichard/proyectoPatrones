package com.libreria.catalogo.proxy;

import com.libreria.catalogo.entidad.Permiso;
import com.libreria.catalogo.entidad.UsuarioLoggeado;
import com.libreria.compartido.Servicio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ProxyServicio<T> implements Servicio<T> {
    private Servicio<T> servicio;
    private UsuarioLoggeado usuario;

    public ProxyServicio(Servicio<T> servicio, UsuarioLoggeado usuario){
        this.servicio = servicio;
        this.usuario = usuario;
    }

    @Override
    public List<T> listar() {
        if(usuario.tienePermiso(Permiso.LEER)) {
            return servicio.listar();
        }
        JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta operacion");
        return new ArrayList<T>();
    }

    @Override
    public T buscar(T entidad) {
        if(usuario.tienePermiso(Permiso.LEER)) {
            return servicio.buscar(entidad);
        }
        JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta operacion");
        return null;
    }


    @Override
    public T guardar(T entidad) {
        if(usuario.tienePermiso(Permiso.CREAR)) {
            return servicio.guardar(entidad);
        }
        JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta operacion");
        return null;
    }

    @Override
    public T editar(T entidad) {
        if(usuario.tienePermiso(Permiso.EDITAR)) {
            return servicio.editar(entidad);
        }
        JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta operacion");
        return null;
    }

    @Override
    public T eliminar(T entidad) {
        if(usuario.tienePermiso(Permiso.ELIMINAR)) {
            return servicio.eliminar(entidad);
        }
        JOptionPane.showMessageDialog(null, "No tienes permisos para realizar esta operacion");
        return null;
    }
}
