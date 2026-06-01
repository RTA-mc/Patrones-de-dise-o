package com.patrones.app.spring_patrones.patrones.estructurales.decorator;

public class PiscinaDecorator extends ListingDecorator {

    public PiscinaDecorator(ListingD listing) {
        super(listing);
    }

    @Override
    public String getDescripcion() {
        return listing.getDescripcion() + " + Piscina";
    }

    @Override
    public double getPrecio() {
        return listing.getPrecio() + 30;
    }
}