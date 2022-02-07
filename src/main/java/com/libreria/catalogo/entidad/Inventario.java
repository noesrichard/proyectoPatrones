package com.libreria.catalogo.entidad;

public class Inventario {
    private String id;
    private Libro libro;
    private String prestado;


    public Inventario() {
    }

    public Inventario(String id, Libro libro, String prestado) {
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

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getPrestado() {
        return prestado;
    }

    public void setPrestado(String prestado) {
        this.prestado = prestado;
    }
    public String [] dataAsVector(){
        return new String[]{id, libro.getId(), libro.getNombre(), libro.getEditorial(), libro.getAutor().getNombre(),
                libro.getCategoria().getNombre(),(prestado.equals("1")) ? "Si": "No"};
    }

}
