package com.patrones.app.spring_patrones.patrones.comportamiento.state;


public interface EstadoReserva {
    String confirmar(ReservaState reserva);
    String cancelar(ReservaState reserva);
    String completar(ReservaState reserva);
    String getNombre();
}