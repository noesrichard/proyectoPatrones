package com.libreria;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.catalogo.entidad.UsuarioLoggeado;
import com.libreria.catalogo.proxy.ProxyServicio;
import com.libreria.catalogo.repositorio.MySQLRepoFactory;
import com.libreria.catalogo.servicios.AutorService;
import com.libreria.catalogo.servicios.ServiciosFactory;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

public class Testing {

    public static void main(String [] args){
        UsuarioLoggeado usuario = UsuarioLoggeado._getUsuario();

        MySQLRepoFactory fabrica = new MySQLRepoFactory();
        ServiciosFactory fabricaServicios = new ServiciosFactory(fabrica);

        Servicio autorService = fabricaServicios.getServicio(ServiciosFactory.AUTOR);
        Servicio userService = fabricaServicios.getServicio(ServiciosFactory.USUARIO);

        UsuarioLoggeado usuarioLoggeado = (UsuarioLoggeado) userService.buscar(new Usuario("usuario", ""));

        ProxyServicio<Autor> proxyServicioAutor = new ProxyServicio<Autor>(autorService,usuario);

        System.out.println(proxyServicioAutor.buscar(new Autor("1", "", "")).toString());
    }
}
