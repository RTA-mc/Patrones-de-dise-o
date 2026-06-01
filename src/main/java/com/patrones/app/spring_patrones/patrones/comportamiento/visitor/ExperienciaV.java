package com.patrones.app.spring_patrones.patrones.comportamiento.visitor;


public class ExperienciaV extends ListingV {

    private final int cupoMaximo;
    private final int duracionHoras;

    public ExperienciaV(String titulo, double precioPorNoche, String ubicacion,
                        int cupoMaximo, int duracionHoras) {
        super(titulo, precioPorNoche, ubicacion);
        this.cupoMaximo = cupoMaximo;
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String aceptar(ListingVisitor visitor) {
        return visitor.visitar(this); 
    }

    public int getCupoMaximo() { return cupoMaximo; }
    public int getDuracionHoras() { return duracionHoras; }
}