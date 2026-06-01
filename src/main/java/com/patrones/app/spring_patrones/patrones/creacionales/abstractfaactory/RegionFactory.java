package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public interface RegionFactory {
    Pago crearPago();
    Notificacion crearNotificacion();
    String getRegion();
}