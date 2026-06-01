package com.patrones.app.spring_patrones.patrones.comportamiento.strategy;

public class PrecioUltimoMinuto implements EstrategiaDescuento {

    @Override
    public double calcular(double precioBase) {
        return precioBase * 0.80; // 20% descuento
    }

    @Override
    public String getNombre() { return "Último Minuto"; }

    @Override
    public String getDescripcion() { return "Descuento del 20% por reserva de último minuto"; }
}