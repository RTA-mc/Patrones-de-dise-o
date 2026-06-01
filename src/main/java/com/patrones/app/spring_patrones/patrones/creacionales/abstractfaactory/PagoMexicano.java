package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public class PagoMexicano implements Pago {

    @Override
    public String procesar(double monto) {
        return "Procesando $" + monto + " MXN vía SPEI — BBVA México";
    }

    @Override
    public String getMoneda() { return "MXN"; }

    @Override
    public String getMetodo() { return "SPEI"; }
}