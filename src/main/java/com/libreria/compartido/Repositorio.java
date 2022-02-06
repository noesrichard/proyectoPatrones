package com.libreria.compartido;

import java.util.List;

public interface Repositorio<T, K> {

    List<T> listar();

    T porId(K id);

    T guardar(T entidad);

    T editar(T entidad, K id);

    T eliminar(K id);

}
