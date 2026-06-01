package com.patrones.app.spring_patrones.patrones.comportamiento.strategy;


public class PrecioNormalS implements EstrategiaDescuento {

    @Override
    public double calcular(double precioBase) {
        return precioBase;
    }

    @Override
    public String getNombre() { return "Precio Normal"; }

    @Override
    public String getDescripcion() { return "Sin modificaciones al precio base"; }
}