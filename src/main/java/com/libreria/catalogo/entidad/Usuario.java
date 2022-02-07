package com.libreria.catalogo.entidad;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
        protected String username, password;
        protected List<Permiso> permisos = new ArrayList<Permiso>();

        public List<Permiso> getPermisos() {
                return permisos;
        }

        public void setPermisos(List<Permiso> permisos) {
                this.permisos = permisos;
        }

        public Usuario(){
        }

        public Usuario(String username, String password) {
                this.username = username;
                this.password = password;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
        public String [] dataAsVector(){
        return new String[]{username, password};
        }
}
