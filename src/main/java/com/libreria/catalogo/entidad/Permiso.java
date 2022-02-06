package com.libreria.catalogo.entidad;

public enum Permiso{
    LEER("LEER"),
    EDITAR("EDITAR"),
    CREAR("CREAR"),
    ELIMINAR("ELIMINAR");

    private final String texto;

    private Permiso(final String texto){
        this.texto = texto;
    }

    @Override
    public String toString(){
        return texto;
    }
}
