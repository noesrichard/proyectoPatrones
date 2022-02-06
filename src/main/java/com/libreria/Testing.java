package com.libreria;

import com.libreria.catalogo.entidad.Libro;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.catalogo.proxy.ProxyServicio;
import com.libreria.catalogo.repositorio.MySQLRepoFactory;
import com.libreria.catalogo.servicios.LibroService;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

public class Testing {

    public static void main(String [] args){
        Usuario usuario = Usuario._getUsuario();
        MySQLRepoFactory fabrica = new MySQLRepoFactory();
        Repositorio repoLibro = fabrica.getRepositorio(MySQLRepoFactory.LIBRO);
        Servicio libroService = new LibroService(repoLibro);
        ProxyServicio<Libro> proxyServicioLibros = new ProxyServicio<Libro>(libroService,usuario);
    }
}
