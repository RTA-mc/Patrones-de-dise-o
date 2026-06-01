package com.patrones.app.spring_patrones.patrones.estructurales.flyweight;

public class UbicacionF {


    private final String ciudad;
    private final String pais;
    private final String moneda;
    private final String idioma;

    public UbicacionF(String ciudad, String pais, String moneda, String idioma) {
        this.ciudad  = ciudad;
        this.pais    = pais;
        this.moneda  = moneda;
        this.idioma  = idioma;
    }

    public String getCiudad()  { return ciudad; }
    public String getPais()    { return pais; }
    public String getMoneda()  { return moneda; }
    public String getIdioma()  { return idioma; }

    public String getResumen() {
        return ciudad + ", " + pais + " | " + moneda + " | " + idioma;
    }
}