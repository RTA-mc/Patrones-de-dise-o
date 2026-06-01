package com.patrones.app.spring_patrones.patrones.comportamiento.state;

public class EstadoCancelada implements EstadoReserva {

    @Override
    public String confirmar(ReservaState reserva) {
        return " No puedes confirmar una reserva cancelada";
    }

    @Override
    public String cancelar(ReservaState reserva) {
        return " La reserva ya está cancelada";
    }

    @Override
    public String completar(ReservaState reserva) {
        return " No puedes completar una reserva cancelada";
    }

    @Override
    public String getNombre() { return "Cancelada"; }
}