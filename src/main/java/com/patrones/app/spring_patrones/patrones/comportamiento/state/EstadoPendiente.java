package com.patrones.app.spring_patrones.patrones.comportamiento.state;
public class EstadoPendiente implements EstadoReserva {

    @Override
    public String confirmar(ReservaState reserva) {
        reserva.setEstado(new EstadoConfirmada());
        return " Reserva confirmada — pago procesado correctamente";
    }

    @Override
    public String cancelar(ReservaState reserva) {
        reserva.setEstado(new EstadoCancelada());
        return " Reserva cancelada desde pendiente";
    }

    @Override
    public String completar(ReservaState reserva) {
        return " No puedes completar una reserva que aún está pendiente";
    }

    @Override
    public String getNombre() { return "Pendiente"; }
}