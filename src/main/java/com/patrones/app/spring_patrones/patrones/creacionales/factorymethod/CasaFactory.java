package com.patrones.app.spring_patrones.patrones.creacionales.factorymethod;

public class CasaFactory extends AlojamientoFactory {

    @Override
    public Listing crearListing(String titulo, String descripcion) {
        return new Listing("Casa Completa", titulo, descripcion,
        "Requiere: fotos de cada habitación, patio o jardín, capacidad máxima de huéspedes");
    }
    
}
