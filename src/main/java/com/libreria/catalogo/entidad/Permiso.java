package com.libreria.catalogo.entidad;

public enum Permiso{
    LEER("LEER", 1),
    EDITAR("EDITAR", 2),
    CREAR("CREAR", 3),
    ELIMINAR("ELIMINAR", 4);

    private final String texto;
    private final int id;

    private Permiso(final String texto, int id){
        this.texto = texto;
        this.id = id;
    }

    @Override
    public String toString(){
        return texto;
    }

    public static Permiso getById(int id){
        for(Permiso p : values()) {
            if(p.id == id) {
                return p;
            }
        }
        return null;
    }
}
