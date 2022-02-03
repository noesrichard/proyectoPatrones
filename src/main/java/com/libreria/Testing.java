package com.libreria;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.articulo.Libro;
import com.libreria.catalogo.repositorio.FactoryRepos;
import com.libreria.catalogo.servicios.CrearLibro;
import com.libreria.compartido.Conexion;

import java.sql.Connection;

public class Testing {

    public static void main(String [] args){
        Conexion con = Conexion._getConexion();
        Connection conexion = con.getCon();
        FactoryRepos factory = new FactoryRepos();
        Autor a = new Autor("autor1", "a", "a");
        Categoria cat = new Categoria("fan", "a");
        Libro l = new Libro("libro2","libro222", "peruana", a,cat);
        CrearLibro cr = new CrearLibro(factory.getRepositorio(FactoryRepos.LIBRO));
        cr.execute(l);
    }
}
