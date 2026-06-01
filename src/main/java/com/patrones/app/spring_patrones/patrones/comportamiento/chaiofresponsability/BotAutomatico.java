package com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability;

public class BotAutomatico extends ManejadorSoporte {

    @Override
    public String manejar(SolicitudSoporteC solicitud) {
        if (solicitud.getNivel() == 1) {
            return "[Bot] Problema simple resuelto automáticamente para "
                    + solicitud.getUsuario() + ": " + solicitud.getProblema();
        }
        return pasarAlSiguiente(solicitud);
    }

    @Override
    public String getNombre() { return "Bot Automático"; }
}