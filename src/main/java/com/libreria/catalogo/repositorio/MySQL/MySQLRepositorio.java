package com.libreria.catalogo.repositorio.MySQL;

import com.libreria.compartido.Conexion;
import com.libreria.compartido.Repositorio;

import java.sql.Connection;
import java.util.List;

public abstract class MySQLRepositorio<T, K> implements Repositorio<T,K> {

    protected Connection conexion;

    public MySQLRepositorio(){
       this.conexion = Conexion._getConexion().getCon();
    }

}
