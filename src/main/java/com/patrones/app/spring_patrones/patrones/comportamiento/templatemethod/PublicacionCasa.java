package com.patrones.app.spring_patrones.patrones.comportamiento.templatemethod;


public class PublicacionCasa extends PublicacionListing {

    @Override
    protected String validarDatos(String titulo, double precio) {
        return "Casa validada: " + titulo + " precio " + precio;
    }

    @Override
    protected String calcularPrecio(double precio) {
        double precioFinal = precio * 1.10; 
        return "Precio casa con recargo 10%: " + precioFinal;
    }

    @Override
    protected String generarDescripcion(String titulo) {
        return "Casa completa: " + titulo + " — acceso total a la propiedad";
    }

    @Override
    protected String publicarListing(String titulo) {
        return "Casa '" + titulo + "' publicada en Airbnb";
    }

    @Override
    public String getTipo() { return "Casa"; }
}