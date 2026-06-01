package com.patrones.app.spring_patrones.patrones.comportamiento.observer;


public interface ObservadorReserva {
    String actualizar(String evento, String detalles);
    String getNombre();
}