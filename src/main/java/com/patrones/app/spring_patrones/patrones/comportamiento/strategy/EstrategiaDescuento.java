package com.patrones.app.spring_patrones.patrones.comportamiento.strategy;
public interface EstrategiaDescuento {
    double calcular(double precioBase);
    String getNombre();
    String getDescripcion();
}