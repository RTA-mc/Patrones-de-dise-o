package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;


public class MexicoFactory implements RegionFactory {

    @Override
    public Pago crearPago() { return new PagoMexicano(); }

    @Override
    public Notificacion crearNotificacion() { return new NotificacionMexicana(); }

    @Override
    public String getRegion() { return "México"; }
}