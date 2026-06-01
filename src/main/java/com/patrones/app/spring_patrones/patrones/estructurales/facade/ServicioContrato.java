package com.patrones.app.spring_patrones.patrones.estructurales.facade;

public class ServicioContrato {

    public String generarContrato(String huesped, String alojamiento,
                                   String fechaEntrada, String fechaSalida) {
        return "Contrato generado — " + huesped + " en " + alojamiento
                + " del " + fechaEntrada + " al " + fechaSalida;
    }

    public String firmarContrato(String huesped) {
        return "Contrato firmado digitalmente por " + huesped;
    }
}