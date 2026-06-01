package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public interface Notificacion {
    String enviar(String mensaje);
    String getCanal();
}