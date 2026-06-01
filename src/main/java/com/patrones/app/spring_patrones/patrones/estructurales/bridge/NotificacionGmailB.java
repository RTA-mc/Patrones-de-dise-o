package com.patrones.app.spring_patrones.patrones.estructurales.bridge;



public class NotificacionGmailB implements NotificacionB {
    @Override
    public String enviar(String mensaje) {
        return "[Email] " + mensaje;
    }
}