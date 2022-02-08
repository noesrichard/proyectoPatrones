package com.libreria.compartido;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion{

    private static Conexion instancia = null;
    private Connection con;

    private Conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             this.con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/biblio","root","");
            System.out.println("Conectado");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public Connection getCon(){
        return con;
    }

    public static Conexion _getConexion(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
}
