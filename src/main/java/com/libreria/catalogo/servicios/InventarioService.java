package com.libreria.catalogo.servicios;

import com.libreria.catalogo.entidad.Inventario;
import com.libreria.compartido.Repositorio;
import com.libreria.compartido.Servicio;

import java.util.List;

public class InventarioService implements Servicio<Inventario> {
    Repositorio repositorio;

    public InventarioService(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Inventario> listar() {
        return repositorio.listar();
    }

    @Override
    public Inventario buscar(Inventario entidad) {
        return (Inventario) repositorio.porId(entidad.getId());
    }

    @Override
    public Inventario guardar(Inventario entidad) {
        return (Inventario) repositorio.guardar(entidad);
    }

    @Override
    public Inventario editar(Inventario entidad) {
        return (Inventario) repositorio.editar(entidad, entidad.getId());
    }

    @Override
    public Inventario eliminar(Inventario entidad) {
        return (Inventario) repositorio.eliminar(entidad.getId());
    }
}
