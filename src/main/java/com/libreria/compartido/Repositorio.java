package com.libreria.compartido;

import java.util.List;

public interface Repositorio<T, K> {

    List<T> listar();

    T porId(K id);

    T crear(T entidad);

    T editar(T entidad);

    T eliminar(T entidad);

}
