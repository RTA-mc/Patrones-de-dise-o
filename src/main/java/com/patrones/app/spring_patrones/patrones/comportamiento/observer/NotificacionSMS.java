package com.patrones.app.spring_patrones.patrones.comportamiento.observer;

public class NotificacionSMS implements ObservadorReserva {

    @Override
    public String actualizar(String evento, String detalles) {
        return switch (evento) {
            case "RESERVA_CONFIRMADA" -> "[SMS] Tu reserva fue confirmada — " + detalles;
            case "RESERVA_CANCELADA"  -> "[SMS] Tu reserva fue cancelada — " + detalles;
            case "RESERVA_COMPLETADA" -> "[SMS] Gracias por tu estadía — " + detalles;
            default -> "[SMS] Evento: " + evento;
        };
    }

    @Override
    public String getNombre() { return "Notificación SMS"; }
}