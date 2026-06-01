package com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability;


public class SupervisorC extends ManejadorSoporte {

    @Override
    public String manejar(SolicitudSoporteC solicitud) {
        if (solicitud.getNivel() == 3) {
            return "[Supervisor] Problema complejo resuelto por supervisor para "
                    + solicitud.getUsuario() + ": " + solicitud.getProblema();
        }
        return pasarAlSiguiente(solicitud);
    }

    @Override
    public String getNombre() { return "Supervisor"; }
}