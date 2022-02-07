package com.libreria;

import com.libreria.catalogo.entidad.Autor;
import com.libreria.catalogo.entidad.Libro;
import com.libreria.catalogo.entidad.Usuario;
import com.libreria.catalogo.entidad.UsuarioLoggeado;
import com.libreria.catalogo.proxy.ProxyServicio;
import com.libreria.catalogo.repositorio.MySQLRepoFactory;
import com.libreria.catalogo.servicios.ServiciosFactory;
import com.libreria.compartido.Servicio;

public class Testing {

    public static void main(String [] args){
        UsuarioLoggeado usuario = UsuarioLoggeado._getUsuario();

        MySQLRepoFactory fabricaRepositorios = new MySQLRepoFactory();
        ServiciosFactory fabricaServicios = new ServiciosFactory(fabricaRepositorios);

        Servicio autorService = fabricaServicios.getServicio(ServiciosFactory.AUTOR);
        Servicio<Usuario> userService = fabricaServicios.getServicio(ServiciosFactory.USUARIO);
        Servicio libroService = fabricaServicios.getServicio(ServiciosFactory.LIBRO);

        Usuario usuarioLoggeado = userService.buscar(new Usuario("usuario", ""));
        usuario.setUsername(usuarioLoggeado.getUsername());
        usuario.setPassword(usuarioLoggeado.getPassword());
        usuario.setPermisos(usuarioLoggeado.getPermisos());

        ProxyServicio<Autor> proxyServicioAutor = new ProxyServicio<Autor>(autorService,usuario);

        System.out.println(libroService.buscar(new Libro("1", "", "", null, null)));
        System.out.println(proxyServicioAutor.buscar(new Autor("1", "", "")).toString());
    }
}
