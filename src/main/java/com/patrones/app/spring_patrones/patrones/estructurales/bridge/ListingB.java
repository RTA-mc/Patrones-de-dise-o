package com.patrones.app.spring_patrones.patrones.estructurales.bridge;

public abstract class ListingB {
        protected NotificacionB notificacion;

    public ListingB(NotificacionB notificacion) {
        this.notificacion = notificacion;
    }

    public abstract String publicar();
}

