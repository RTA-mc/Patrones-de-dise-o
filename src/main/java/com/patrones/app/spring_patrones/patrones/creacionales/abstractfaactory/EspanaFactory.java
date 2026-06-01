package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;
public class EspanaFactory implements RegionFactory {

    @Override
    public Pago crearPago() { return new PagoEspanol(); }

    @Override
    public Notificacion crearNotificacion() { return new NotificacionEspanola(); }

    @Override
    public String getRegion() { return "España"; }
}