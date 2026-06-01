package com.patrones.app.spring_patrones.patrones.estructurales.bridge;

public class NotificacionSMSB implements NotificacionB {
    @Override
    public String enviar(String mensaje) {
        return "[SMS] " + mensaje;
    }
}