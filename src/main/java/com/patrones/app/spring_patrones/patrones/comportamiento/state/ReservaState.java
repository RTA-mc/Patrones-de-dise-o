package com.patrones.app.spring_patrones.patrones.comportamiento.state;


public class ReservaState {

    private EstadoReserva estado;
    private final String id;

    public ReservaState(String id) {
        this.id     = id;
        this.estado = new EstadoPendiente(); // siempre empieza pendiente
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    public String confirmar()  { return estado.confirmar(this); }
    public String cancelar()   { return estado.cancelar(this); }
    public String completar()  { return estado.completar(this); }

    public String getEstadoActual() { return estado.getNombre(); }
    public String getId()           { return id; }
}