package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public class NotificacionColombiana implements Notificacion {

    @Override
    public String enviar(String mensaje) {
        return "[SMS Colombia] " + mensaje + " — Enviado vía Claro/Movistar";
    }

    @Override
    public String getCanal() { return "SMS"; }
}