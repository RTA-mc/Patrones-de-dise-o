package com.patrones.app.spring_patrones.patrones.estructurales.proxy;

public class SerivicioAlojamientoReal implements ServicioAlojamiento {

    @Override
    public String verDetalle(String alojamientoId) {
        return "Alojamiento: "+alojamientoId+ ": Casa en Madrid, 3 hab, WiFi, piscina";
    }

    @Override
    public String verPrecio(String alojamientoId) {
        return "Precio de " + alojamientoId + ": €120/noche";
    }

    @Override
    public String verDatosAnfitrion(String alojamientoId) {
        return "Anfitrión de " + alojamientoId + ": Juan García — juan@email.com — +34 600 123 456";
    }
}
