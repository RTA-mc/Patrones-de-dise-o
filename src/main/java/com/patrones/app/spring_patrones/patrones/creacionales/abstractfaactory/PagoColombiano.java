package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public class PagoColombiano implements Pago {

    @Override
    public String procesar(double monto) {
        return "Procesando $" + monto + " COP vía PSE — Banco de Bogotá";
    }

    @Override
    public String getMoneda() { return "COP"; }

    @Override
    public String getMetodo() { return "PSE"; }
}