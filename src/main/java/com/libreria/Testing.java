package com.libreria;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Libro;
import com.libreria.catalogo.entidad.Permiso;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.catalogo.proxy.ProxyServicio;
import com.libreria.catalogo.repositorio.MySQLRepoFactory;
import com.libreria.catalogo.servicios.AutorService;
import com.libreria.catalogo.servicios.LibroService;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

public class Testing {

    public static void main(String [] args){
        Usuario usuario = Usuario._getUsuario();
        MySQLRepoFactory fabrica = new MySQLRepoFactory();
        Repositorio repoAutor = fabrica.getRepositorio(MySQLRepoFactory.AUTOR);
        Servicio autorService = new AutorService(repoAutor);
        ProxyServicio<Autor> proxyServicioAutor = new ProxyServicio<Autor>(autorService,usuario);
        System.out.println(proxyServicioAutor.listar().get(0).toString());
    }
}
