package com.patrones.app.spring_patrones.patrones.estructurales.decorator;

public class ListingBase implements ListingD {

    private final String nombre;
    private final double precioBase;

    public ListingBase(String nombre, double precioBase) {
        this.nombre     = nombre;
        this.precioBase = precioBase;
    }

    @Override
    public String getDescripcion() { return nombre; }

    @Override
    public double getPrecio() { return precioBase; }
}