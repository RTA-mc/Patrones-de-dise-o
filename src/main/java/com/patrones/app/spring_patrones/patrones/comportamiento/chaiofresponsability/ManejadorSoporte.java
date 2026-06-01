package com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability;

public abstract class ManejadorSoporte {


    private ManejadorSoporte siguiente;


    public ManejadorSoporte setSiguiente(ManejadorSoporte siguiente) {
        this.siguiente = siguiente;
        return siguiente; 
    }


    protected String pasarAlSiguiente(SolicitudSoporteC solicitud) {
        if (siguiente != null) {
            return siguiente.manejar(solicitud);
        }
        return " Nadie pudo resolver: " + solicitud.getProblema();
    }


    public abstract String manejar(SolicitudSoporteC solicitud);
    public abstract String getNombre();
}