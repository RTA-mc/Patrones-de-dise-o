package com.patrones.app.spring_patrones.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.observer.NotificacionEmail;
import com.patrones.app.spring_patrones.patrones.comportamiento.observer.NotificacionHost;
import com.patrones.app.spring_patrones.patrones.comportamiento.observer.NotificacionSMS;
import com.patrones.app.spring_patrones.patrones.comportamiento.observer.ReservaO;

@RestController
@RequestMapping("/demo/observer")
public class ObserverController {

    private ReservaO reserva;

    public ObserverController() {
        inicializarReserva();
    }

    private void inicializarReserva() {
        reserva = new ReservaO("R-001", "María García", "Loft en Chapinero");
        reserva.suscribir(new NotificacionEmail());
        reserva.suscribir(new NotificacionSMS());
        reserva.suscribir(new NotificacionHost());
    }

    @GetMapping("/estado")
    public Map<String, Object> getEstado() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("id", reserva.getId());
        respuesta.put("huesped", reserva.getHuesped());
        respuesta.put("alojamiento", reserva.getAlojamiento());
        respuesta.put("estado", reserva.getEstado());
        respuesta.put("totalObservadores", reserva.totalObservadores());
        respuesta.put("notificaciones", reserva.getNotificaciones());
        return respuesta;
    }

    @PostMapping("/confirmar")
    public Map<String, Object> confirmar() {
        reserva.confirmar();
        return getEstado();
    }

    @PostMapping("/cancelar")
    public Map<String, Object> cancelar() {
        reserva.cancelar();
        return getEstado();
    }

    @PostMapping("/completar")
    public Map<String, Object> completar() {
        reserva.completar();
        return getEstado();
    }

    @PostMapping("/reset")
    public Map<String, Object> reset() {
        inicializarReserva();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Reserva reiniciada");
        respuesta.put("estado", reserva.getEstado());
        return respuesta;
    }
}