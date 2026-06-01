package com.patrones.app.spring_patrones.patrones.comportamiento.comand;
public class SetDescripcionComando implements Comando {

    private final ListingC listing;
    private final String descripcionNueva;
    private final String descripcionAnterior;

    public SetDescripcionComando(ListingC listing, String descripcionNueva) {
        this.listing = listing;
        this.descripcionNueva = descripcionNueva;
        this.descripcionAnterior = listing.getDescripcion();
    }

    @Override
    public String ejecutar() {
        listing.setDescripcion(descripcionNueva);
        return "Descripción cambiada a: " + descripcionNueva;
    }

    @Override
    public String deshacer() {
        listing.setDescripcion(descripcionAnterior);
        return "Descripción revertida a: " + descripcionAnterior;
    }

    @Override
    public String getDescripcion() {
        return "Cambiar descripción: '" + descripcionAnterior + "' -- '" + descripcionNueva + "'";
    }
}