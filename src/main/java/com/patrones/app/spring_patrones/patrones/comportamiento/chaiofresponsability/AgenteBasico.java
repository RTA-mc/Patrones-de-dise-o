package com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability;


public class AgenteBasico extends ManejadorSoporte {

    @Override
    public String manejar(SolicitudSoporteC solicitud) {
        if (solicitud.getNivel() == 2) {
            return "[Agente] Problema medio resuelto por agente para "
                    + solicitud.getUsuario() + ": " + solicitud.getProblema();
        }
        return pasarAlSiguiente(solicitud);
    }

    @Override
    public String getNombre() { return "Agente Básico"; }
}