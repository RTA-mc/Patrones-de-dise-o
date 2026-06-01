package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public class ColombiaFactory implements RegionFactory {

    public ColombiaFactory() {
    }

    @Override
    public Pago crearPago() { return new PagoColombiano(); }

    @Override
    public Notificacion crearNotificacion() { return new NotificacionColombiana(); }

    @Override
    public String getRegion() { return "Colombia"; }
}