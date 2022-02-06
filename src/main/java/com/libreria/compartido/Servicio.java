package com.libreria.compartido;

import java.util.List;

public interface Servicio<T> {

    List<T> listar();
    T buscar(T entidad);
    T guardar(T entidad);
    T editar(T entidad);
    T eliminar(T entidad);

}
