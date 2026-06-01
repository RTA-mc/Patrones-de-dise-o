package com.patrones.app.spring_patrones.patrones.comportamiento.comand;

public interface Comando {
    String ejecutar();
    String deshacer();
    String getDescripcion();
}