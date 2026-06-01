package com.patrones.app.spring_patrones.patrones.comportamiento.iterator;

import java.util.ArrayList;
import java.util.List;


public class FiltroReservaIterator implements ReservaIterator{
    private final List <ReservaI> reservasFiltradas ;
    private int posicion=0 ;

    public FiltroReservaIterator(List<ReservaI> reservas, String estado, String mes ,double calificacionMin){
        this.reservasFiltradas = new ArrayList<>();

        for (ReservaI reserva : reservas){
            boolean cumpleEstado = estado == null || estado.isEmpty()
                || reserva.getEstado().equalsIgnoreCase(estado);
            boolean cumpleMes = mes == null || mes.isEmpty()
                || reserva.getMes().equalsIgnoreCase(mes);
            boolean cumpleCalificacion = calificacionMin <= 0
                || reserva.getCalificacionHuesped() >= calificacionMin;
        if(cumpleEstado && cumpleMes && cumpleCalificacion){
            reservasFiltradas.add(reserva);
        }
        }
    }
    @Override
    public boolean hasNext() { return posicion < reservasFiltradas.size(); }

    @Override
    public ReservaI next() { return reservasFiltradas.get(posicion++); }

    @Override
    public void reset() { posicion = 0; }

    public int totalEncontradas() { return reservasFiltradas.size(); }

    public double totalIngresos() {
        return reservasFiltradas.stream()
            .mapToDouble(ReservaI::getTotal)
            .sum();
    }
}
