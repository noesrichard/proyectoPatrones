package com.libreria;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Categoria;
import com.libreria.catalogo.entidad.Libro;
import com.libreria.catalogo.repositorio.MySQLRepoFactory;
import com.libreria.catalogo.servicios.LibroService;
import com.libreria.compartido.Conexion;

import java.sql.Connection;

public class Testing {

    public static void main(String [] args){
        Conexion con = Conexion._getConexion();
        Connection conexion = con.getCon();
        MySQLRepoFactory factory = new MySQLRepoFactory();
        Autor a = new Autor("autor1", "a", "a");
        Categoria cat = new Categoria("fan", "a");
        Libro l = new Libro("libro2","libro222", "peruana", a,cat);
        LibroService cr = new LibroService(factory.getRepositorio(MySQLRepoFactory.LIBRO));
        cr.execute(l);
    }
}
