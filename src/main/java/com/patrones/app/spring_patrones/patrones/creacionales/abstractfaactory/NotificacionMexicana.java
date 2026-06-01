package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public class NotificacionMexicana implements Notificacion {

    @Override
    public String enviar(String mensaje) {
        return "[WhatsApp México] " + mensaje + " — Enviado vía Telcel";
    }

    @Override
    public String getCanal() { return "WhatsApp"; }
}