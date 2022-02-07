package com.libreria.app;

import com.libreria.app.paneles.Subscriptor;

public interface Observador {
    public void suscribir(Subscriptor s);
    public void unsuscribir(Subscriptor s);
    public void actualizar();
}
