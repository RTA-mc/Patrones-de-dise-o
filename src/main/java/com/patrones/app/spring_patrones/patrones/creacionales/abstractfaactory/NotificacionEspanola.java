package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;


public class NotificacionEspanola implements Notificacion {

    @Override
    public String enviar(String mensaje) {
        return "[Email España] " + mensaje + " — Enviado vía Movistar ES";
    }

    @Override
    public String getCanal() { return "Email"; }
}