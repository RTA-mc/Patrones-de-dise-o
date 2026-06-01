package com.patrones.app.spring_patrones.patrones.comportamiento.iterator;


import java.util.ArrayList;
import java.util.List;

public class ColeccionReservas {

    private final List<ReservaI> reservas = new ArrayList<>();

    public ColeccionReservas() {
        reservas.add(new ReservaI("R001", "María García", "Loft Chapinero", "confirmada", "enero", 540000, 4.9));
        reservas.add(new ReservaI("R002", "Carlos López", "Loft Chapinero", "completada", "enero", 360000, 4.5));
        reservas.add(new ReservaI("R003", "Ana Martínez", "Loft Chapinero", "pendiente", "febrero", 720000, 4.8));
        reservas.add(new ReservaI("R004", "Pedro Ruiz", "Loft Chapinero", "cancelada", "febrero", 0, 3.9));
        reservas.add(new ReservaI("R005", "Laura Torres", "Loft Chapinero", "confirmada", "marzo", 900000, 5.0));
        reservas.add(new ReservaI("R006", "Diego Herrera", "Loft Chapinero", "completada", "marzo", 450000, 4.7));
        reservas.add(new ReservaI("R007", "Sofia Vargas", "Loft Chapinero", "confirmada", "marzo", 630000, 4.6));
        reservas.add(new ReservaI("R008", "Miguel Castro", "Loft Chapinero", "pendiente", "abril", 810000, 4.2));
    }

    public FiltroReservaIterator crearIterator(String estado, String mes, double calificacionMin) {
        return new FiltroReservaIterator(reservas, estado, mes, calificacionMin);
    }

    public int totalReservas() { return reservas.size(); }
}