package com.patrones.app.spring_patrones.patrones.comportamiento.observer;

public class NotificacionEmail implements ObservadorReserva {

    @Override
    public String actualizar(String evento, String detalles) {
        return switch (evento) {
            case "RESERVA_CONFIRMADA" -> "[EMAIL] Confirmación enviada — " + detalles;
            case "RESERVA_CANCELADA"  -> "[EMAIL] Cancelación notificada — " + detalles;
            case "RESERVA_COMPLETADA" -> "[EMAIL] Solicitud de reseña enviada — " + detalles;
            default -> "[EMAIL] Evento desconocido: " + evento;
        };
    }

    @Override
    public String getNombre() { return "Notificación Email"; }
}