package com.patrones.app.spring_patrones.patrones.estructurales.facade;


public class ServicioNotificacion {

    public String notificarHuesped(String huesped) {
        return "Email enviado a " + huesped + ": Tu reserva está confirmada";
    }

    public String notificarAnfitrion(String alojamiento) {
        return "SMS enviado al anfitrión de " + alojamiento + ": Tienes una nueva reserva";
    }
}