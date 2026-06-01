package com.patrones.app.spring_patrones.patrones.estructurales.decorator;



public class ParkingDecorator extends ListingDecorator {

    public ParkingDecorator(ListingD listing) {
        super(listing);
    }

    @Override
    public String getDescripcion() {
        return listing.getDescripcion() + " + Parking";
    }

    @Override
    public double getPrecio() {
        return listing.getPrecio() + 15;
    }
}