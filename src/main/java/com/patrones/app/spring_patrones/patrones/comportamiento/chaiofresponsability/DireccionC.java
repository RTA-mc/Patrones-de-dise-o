package com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability;


public class DireccionC extends ManejadorSoporte {

    @Override
    public String manejar(SolicitudSoporteC solicitud) {
        if (solicitud.getNivel() == 4) {
            return "[Dirección] Caso crítico resuelto por dirección para "
                    + solicitud.getUsuario() + ": " + solicitud.getProblema();
        }
        return pasarAlSiguiente(solicitud);
    }

    @Override
    public String getNombre() { return "Dirección"; }
}