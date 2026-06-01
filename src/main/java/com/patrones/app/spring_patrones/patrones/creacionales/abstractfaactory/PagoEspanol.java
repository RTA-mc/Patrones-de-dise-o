package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;


public class PagoEspanol implements Pago {

    @Override
    public String procesar(double monto) {
        return "Procesando €" + monto + " EUR vía SEPA — Santander España";
    }

    @Override
    public String getMoneda() { return "EUR"; }

    @Override
    public String getMetodo() { return "SEPA"; }
}