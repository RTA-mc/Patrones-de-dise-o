package com.patrones.app.spring_patrones.patrones.creacionales.factorymethod;

public class ApartamentoFactory extends AlojamientoFactory {

    @Override
    public Listing crearListing(String titulo, String descripcion) {
        return new Listing("Apartamento", titulo, descripcion,
        "Requiere: mínimo 3 fotos, área en m², número de habitaciones y baños");
    }
    
    
}
