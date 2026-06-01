package com.patrones.app.spring_patrones.model;

public class PatronDTO {
    private final String id ;
    private final String nombre ;
    private  final String categoria ;
    private final String resumen;
    private final String definicion ;
    @SuppressWarnings("unused")
    private final String contextoAirbnb;
    @SuppressWarnings("unused")
    private final String uml;
    @SuppressWarnings("unused")
    private final String codigo;
    public PatronDTO(String id, String nombre, String categoria, String resumen, String definicion, String contextoAirbnb, String uml, String codigo){
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.resumen = resumen;
        this.definicion = definicion;
        this.contextoAirbnb = contextoAirbnb;
        this.uml = uml;
        this.codigo = codigo;
    }
    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public String getCategoria(){return categoria;}
    public String getResumen(){return resumen;}
    public String getDefinicion(){return definicion;}
}
