package com.patrones.app.spring_patrones.patrones.comportamiento.visitor;

public abstract class ListingV {

    protected final String titulo;
    protected final double precioPorNoche;
    protected final String ubicacion;

    public ListingV(String titulo, double precioPorNoche, String ubicacion) {
        this.titulo = titulo;
        this.precioPorNoche = precioPorNoche;
        this.ubicacion = ubicacion;
    }


    public abstract String aceptar(ListingVisitor visitor);

    public String getTitulo() { return titulo; }
    public double getPrecioPorNoche() { return precioPorNoche; }
    public String getUbicacion() { return ubicacion; }
}