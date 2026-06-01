package com.patrones.app.spring_patrones.patrones.comportamiento.state;


public class EstadoConfirmada implements EstadoReserva {

    @Override
    public String confirmar(ReservaState reserva) {
        return " La reserva ya está confirmada";
    }

    @Override
    public String cancelar(ReservaState reserva) {
        reserva.setEstado(new EstadoCancelada());
        return " Reserva cancelada — se procesará el reembolso";
    }

    @Override
    public String completar(ReservaState reserva) {
        reserva.setEstado(new EstadoCompletada());
        return " Reserva completada — el huésped ha finalizado su estadía";
    }

    @Override
    public String getNombre() { return "Confirmada"; }
}