package com.patrones.app.spring_patrones.patrones.estructurales.composite;


public class ListingIndividual implements  Ubicacion{
    private final String nombre;
    private final String tipo;

    public ListingIndividual(String nombre, String tipo){
        this.nombre=nombre;
        this.tipo = tipo;
    }
    @Override
    public String getNombre(){return nombre;}

    @Override
    public int contarListings() {
        return 1;
    }

    @Override
    public String mostrar(String sangria) {
        return  sangria+"casa: "+nombre+"("+tipo+")";
    }
}
