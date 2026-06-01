package com.patrones.app.spring_patrones.patrones.creacionales.prototype;

public class PreciosTemporadaBaja extends EstrategiaPreciosBase {

    public PreciosTemporadaBaja() {
        super("Temporada Baja", 20, 0);
    }

    public PreciosTemporadaBaja(PreciosTemporadaBaja otra) {
        super(otra);
    }

    @Override
    public EstrategiaPrecios clonar() {
        return new PreciosTemporadaBaja(this);
    }
}