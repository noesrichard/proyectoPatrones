package com.libreria.catalogo.entidad;

public class Inventario {
    private String id;
    private String libro;
    private String prestado;


    public Inventario() {
    }

    public Inventario(String id, String libro, String prestado) {
        this.id = id;
        this.libro = libro;
        this.prestado = prestado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getPrestado() {
        return prestado;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }
    public String [] dataAsVector(){
        return new String[]{id, libro,prestado};
    }

}
