package com.patrones.app.spring_patrones.controller;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.state.ReservaState;

@RestController
@RequestMapping("/demo/state")
public class StateController {

    // Guardamos reservas en memoria para simular cambios de estado
    private final Map<String, ReservaState> reservas = new HashMap<>();

    @PostMapping("/crear")
    public Map<String, Object> crear(@RequestBody Map<String, String> body) {
        String id = body.get("id");
        if (id == null) return Map.of("error", "Campo requerido: id");

        ReservaState reserva = new ReservaState(id);
        reservas.put(id, reserva);

        Map<String, Object> respuesta = new LinkedHashMap<>();
        
        respuesta.put("id",          reserva.getId());
        respuesta.put("estado",      reserva.getEstadoActual());
        respuesta.put("mensaje",     "Reserva creada en estado Pendiente");
        return respuesta;
    }

    @PostMapping("/accion")
    public Map<String, Object> accion(@RequestBody Map<String, String> body) {
        String id     = body.get("id");
        String accion = body.get("accion");

        if (id == null || accion == null)
            return Map.of("error", "Campos requeridos: id, accion");

        ReservaState reserva = reservas.get(id);
        if (reserva == null)
            return Map.of("error", "Reserva no encontrada: " + id);

        String estadoAntes  = reserva.getEstadoActual();
        String resultado = switch (accion.toLowerCase()) {
            case "confirmar" -> reserva.confirmar();
            case "cancelar"  -> reserva.cancelar();
            case "completar" -> reserva.completar();
            default -> "Acción no válida. Usa: confirmar, cancelar, completar";
        };

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("id",           id);
        respuesta.put("estadoAntes",  estadoAntes);
        respuesta.put("accion",       accion);
        respuesta.put("estadoDespues", reserva.getEstadoActual());
        respuesta.put("resultado",    resultado);
        return respuesta;
    }
}