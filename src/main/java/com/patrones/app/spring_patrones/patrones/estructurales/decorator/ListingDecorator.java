package com.patrones.app.spring_patrones.patrones.estructurales.decorator;

public abstract class ListingDecorator implements ListingD {


    protected final ListingD listing;

    public ListingDecorator(ListingD listing) {
        this.listing = listing;
    }

    @Override
    public String getDescripcion() { return listing.getDescripcion(); }

    @Override
    public double getPrecio() { return listing.getPrecio(); }
}