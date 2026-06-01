package com.patrones.app.spring_patrones.patrones.estructurales.facade;

public class ServicioCalendario {

    public String bloquearFechas(String alojamiento,
                                  String fechaEntrada, String fechaSalida) {
        return "Fechas bloqueadas en calendario de " + alojamiento
                + ": " + fechaEntrada + " → " + fechaSalida;
    }
}