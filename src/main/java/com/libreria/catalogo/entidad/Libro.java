package com.libreria.catalogo.entidad;


public class Libro{
    private String id, nombre, editorial;
    private Autor autor;
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Libro(String id, String nombre, String editorial, Autor autor, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", editorial='" + editorial + '\'' +
                ", id_autor='" + autor.getId() + '\'' +
                ", autor='" + autor.getNombre() + '\'' +
                ", id_categoria='" + categoria.getId() + '\'' +
                ", categoria='" + categoria.getNombre() + '\'' +
                '}';
    }

    public String [] dataAsVector(){
        return new String[]{id, nombre, editorial,autor.getNombre(), categoria.getNombre()};
    }
}
