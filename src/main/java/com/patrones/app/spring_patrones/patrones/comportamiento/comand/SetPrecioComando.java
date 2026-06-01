package com.patrones.app.spring_patrones.patrones.comportamiento.comand;

public class SetPrecioComando implements Comando {

    private final ListingC listing;
    private final double precioNuevo;
    private final double precioAnterior;

    public SetPrecioComando(ListingC listing, double precioNuevo) {
        this.listing = listing;
        this.precioNuevo = precioNuevo;
        this.precioAnterior = listing.getPrecio(); 
    }

    @Override
    public String ejecutar() {
        listing.setPrecio(precioNuevo);
        return "Precio cambiado a $" + precioNuevo;
    }

    @Override
    public String deshacer() {
        listing.setPrecio(precioAnterior);
        return "Precio revertido a $" + precioAnterior;
    }

    @Override
    public String getDescripcion() {
        return "Cambiar precio: $" + precioAnterior + " -- $" + precioNuevo;
    }
}