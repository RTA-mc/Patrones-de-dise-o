package com.patrones.app.spring_patrones.patrones.comportamiento.templatemethod;

public class PublicacionApartamento extends PublicacionListing{

    @Override
    protected String validarDatos(String titulo, double precio) {
        return "Apartamento: "+ titulo +"-precio: "+precio;
    }

    @Override
    protected String calcularPrecio(double precio) {
        double precioFinal = precio * 1.05;
        return "apartamento con 5% de recargo: "+ precioFinal ;
    }

    @Override
    protected String generarDescripcion(String titulo) {
        return "Apartemento" +titulo + "acceso al apartamento completo y al parque de conjunto";
    }

    @Override
    protected String publicarListing(String titulo) {
        return "Apartamento '" + titulo + "' publicada en Airbnb";
    }


    @Override
    public String getTipo() { return "Apartamento";}
    
}
