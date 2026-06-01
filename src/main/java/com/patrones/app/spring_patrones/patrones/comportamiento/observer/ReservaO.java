package com.patrones.app.spring_patrones.patrones.comportamiento.observer;

import java.util.ArrayList;
import java.util.List;


public class ReservaO {

    private final String id;
    private final String huesped;
    private final String alojamiento;
    private String estado;
    private final List<ObservadorReserva> observadores = new ArrayList<>();
    private final List<String> notificaciones = new ArrayList<>();

    public ReservaO(String id, String huesped, String alojamiento) {
        this.id = id;
        this.huesped = huesped;
        this.alojamiento = alojamiento;
        this.estado = "pendiente";
    }

    public void suscribir(ObservadorReserva observador) {
        observadores.add(observador);
    }

    public void desuscribir(ObservadorReserva observador) {
        observadores.remove(observador);
    }

    private void notificarTodos(String evento) {
        String detalles = "Reserva " + id + " | " + huesped + " | " + alojamiento;
        for (ObservadorReserva obs : observadores) {
            String resultado = obs.actualizar(evento, detalles);
            notificaciones.add(resultado);
        }
    }

    public void confirmar() {
        this.estado = "confirmada";
        notificarTodos("RESERVA_CONFIRMADA");
    }

    public void cancelar() {
        this.estado = "cancelada";
        notificarTodos("RESERVA_CANCELADA");
    }

    public void completar() {
        this.estado = "completada";
        notificarTodos("RESERVA_COMPLETADA");
    }

    public String getId() { return id; }
    public String getHuesped() { return huesped; }
    public String getAlojamiento() { return alojamiento; }
    public String getEstado() { return estado; }
    public List<String> getNotificaciones() { return notificaciones; }
    public int totalObservadores() { return observadores.size(); }
}