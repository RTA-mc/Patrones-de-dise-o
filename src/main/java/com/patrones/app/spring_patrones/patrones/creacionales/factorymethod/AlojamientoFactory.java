package com.patrones.app.spring_patrones.patrones.creacionales.factorymethod;

public abstract class AlojamientoFactory {
    public abstract Listing crearListing(String titulo, String descripcion);
        
    public String publicar(String titulo, String descripcion){
        Listing listing = crearListing(titulo, descripcion);
        String validacion = listing.validar();
        String guardando = listing.guardar();
        return validacion + "|"+guardando;
    }
    
}
