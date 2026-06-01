package com.patrones.app.spring_patrones.patrones.estructurales.bridge;

public class CasaCompletaB extends ListingB {

    public CasaCompletaB(NotificacionB notificacion) {
        super(notificacion);
    }

    @Override
    public String publicar() {
        return "Casa publicada — " + notificacion.enviar("Tu casa está lista para recibir huéspedes");
    }
}