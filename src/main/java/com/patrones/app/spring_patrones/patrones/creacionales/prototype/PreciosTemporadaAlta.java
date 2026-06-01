package com.patrones.app.spring_patrones.patrones.creacionales.prototype;

public class PreciosTemporadaAlta extends EstrategiaPreciosBase  {

    public PreciosTemporadaAlta() {
    super("Temporada Alta", 0, 40);
}

    public PreciosTemporadaAlta(PreciosTemporadaAlta otra) {
        super(otra);
    }

    @Override
    public EstrategiaPrecios clonar() {
        return new PreciosTemporadaAlta(this);
    }
    
}
