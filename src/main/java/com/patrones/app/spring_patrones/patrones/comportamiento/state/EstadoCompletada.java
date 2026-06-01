package com.patrones.app.spring_patrones.patrones.comportamiento.state;

public class EstadoCompletada implements EstadoReserva {

    @Override
    public String confirmar(ReservaState reserva) {
        return " No puedes confirmar una reserva ya completada";
    }

    @Override
    public String cancelar(ReservaState reserva) {
        return " No puedes cancelar una reserva ya completada";
    }

    @Override
    public String completar(ReservaState reserva) {
        return " La reserva ya está completada";
    }

    @Override
    public String getNombre() { return "Completada"; }
}