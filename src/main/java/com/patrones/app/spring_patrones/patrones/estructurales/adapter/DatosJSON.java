package com.patrones.app.spring_patrones.patrones.estructurales.adapter;



public class DatosJSON {
    private final String empresa;
    private final double precio;
    private final int volumen;

    public DatosJSON(String empresa, double precio, int volumen) {
        this.empresa = empresa;
        this.precio  = precio;
        this.volumen = volumen;
    }

    public String getDatosEnJSON() {
        return "{\"empresa\": \"" + empresa + "\","
             + "\"precio\": "     + precio  + ","
             + "\"volumen\": "    + volumen + "}";
    }

    public String getEmpresa() { return empresa; }
    public double getPrecio()  { return precio; }
    public int getVolumen()    { return volumen; }
}