package com.patrones.app.spring_patrones.patrones.comportamiento.strategy;

public class CalculadoraPrecio {

    private EstrategiaDescuento estrategia;

    public CalculadoraPrecio(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    // Permite cambiar la estrategia en tiempo de ejecución
    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(double precioBase) {
        return Math.round(estrategia.calcular(precioBase) * 100.0) / 100.0;
    }

    public String getEstrategiaNombre()      { return estrategia.getNombre(); }
    public String getEstrategiaDescripcion() { return estrategia.getDescripcion(); }
}