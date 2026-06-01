package com.patrones.app.spring_patrones.patrones.comportamiento.observer;

public class NotificacionHost implements ObservadorReserva {

    @Override
    public String actualizar(String evento, String detalles) {
        return switch (evento) {
            case "RESERVA_CONFIRMADA" -> "[HOST] Nueva reserva confirmada — " + detalles;
            case "RESERVA_CANCELADA"  -> "[HOST] Una reserva fue cancelada — " + detalles;
            case "RESERVA_COMPLETADA" -> "[HOST] Huésped completó su estadía — " + detalles;
            default -> "[HOST] Evento: " + evento;
        };
    }

    @Override
    public String getNombre() { return "Notificación Host"; }
}