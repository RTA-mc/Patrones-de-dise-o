package com.patrones.app.spring_patrones.patrones.creacionales.prototype;

public interface EstrategiaPrecios {
    EstrategiaPrecios clonar();
    double calcularPrecioFinal(double precioBase);
    String getResumen();
    String getNombre();
}