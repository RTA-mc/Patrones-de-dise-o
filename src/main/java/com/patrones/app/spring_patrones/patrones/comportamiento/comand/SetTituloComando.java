package com.patrones.app.spring_patrones.patrones.comportamiento.comand;


public class SetTituloComando implements Comando {

    private final ListingC listing;
    private final String tituloNuevo;
    private final String tituloAnterior;

    public SetTituloComando(ListingC listing, String tituloNuevo) {
        this.listing = listing;
        this.tituloNuevo = tituloNuevo;
        this.tituloAnterior = listing.getTitulo();
    }

    @Override
    public String ejecutar() {
        listing.setTitulo(tituloNuevo);
        return "Título cambiado a: " + tituloNuevo;
    }

    @Override
    public String deshacer() {
        listing.setTitulo(tituloAnterior);
        return "Título revertido a: " + tituloAnterior;
    }

    @Override
    public String getDescripcion() {
        return "Cambiar título: '" + tituloAnterior + "' -- '" + tituloNuevo + "'";
    }
}