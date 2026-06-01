package com.patrones.app.spring_patrones.patrones.estructurales.bridge;


public class ApartamentoB extends ListingB {

    public ApartamentoB(NotificacionB notificacion) {
        super(notificacion);
    }

    @Override
    public String publicar() {
        return "Apartamento publicado — " + notificacion.enviar("Tu apartamento está lista para reservar");
    }
}