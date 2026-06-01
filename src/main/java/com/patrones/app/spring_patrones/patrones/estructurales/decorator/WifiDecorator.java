package com.patrones.app.spring_patrones.patrones.estructurales.decorator;

public class WifiDecorator extends ListingDecorator {

    public WifiDecorator(ListingD listing) {
        super(listing);
    }

    @Override
    public String getDescripcion() {
        return listing.getDescripcion() + " + WiFi";
    }

    @Override
    public double getPrecio() {
        return listing.getPrecio() + 10;
    }
}