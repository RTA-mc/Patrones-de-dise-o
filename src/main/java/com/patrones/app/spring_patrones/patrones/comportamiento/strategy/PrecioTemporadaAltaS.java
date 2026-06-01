package com.patrones.app.spring_patrones.patrones.comportamiento.strategy;


public class PrecioTemporadaAltaS implements EstrategiaDescuento {

    @Override
    public double calcular(double precioBase) {
        return precioBase * 1.30; // 30% recargo
    }

    @Override
    public String getNombre() { return "Temporada Alta"; }

    @Override
    public String getDescripcion() { return "Recargo del 30% por temporada alta"; }
}