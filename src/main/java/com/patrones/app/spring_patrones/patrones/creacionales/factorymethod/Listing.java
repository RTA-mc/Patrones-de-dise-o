package com.patrones.app.spring_patrones.patrones.creacionales.factorymethod;

public class Listing {
    private final String tipo;
    private final String titulo;
    private  final String descripcion;
    private final String requisitos;
    public Listing(String tipo, String titulo, String descripcion, String requisitos){
        this.tipo = tipo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.requisitos = requisitos;
    }
    public String validar(){
        return "Validacion tipo: "+ tipo + "-verificando requisitos";
    }
    public String guardar(){
        return "Listing guardado "+tipo +"(" +tipo +")";
    }
    public String getTipo(){return tipo;}
    public String getTitulo(){return  titulo;}
    public String getDescripcion(){return descripcion;}
    public String getRequisitos(){return requisitos;}
}
