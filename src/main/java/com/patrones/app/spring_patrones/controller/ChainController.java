package com.patrones.app.spring_patrones.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability.AgenteBasico;
import com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability.BotAutomatico;
import com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability.DireccionC;
import com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability.ManejadorSoporte;
import com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability.SolicitudSoporteC;
import com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability.SupervisorC;
@RestController
@RequestMapping("/demo/chain")
public class ChainController {

    private final ManejadorSoporte cadena = construirCadena();

    private ManejadorSoporte construirCadena() {
        BotAutomatico bot        = new BotAutomatico();
        AgenteBasico  agente     = new AgenteBasico();
        SupervisorC    supervisor = new SupervisorC();
        DireccionC     direccion  = new DireccionC();

        // Encadenamos: bot → agente → supervisor → dirección
        bot.setSiguiente(agente)
           .setSiguiente(supervisor)
           .setSiguiente(direccion);

        return bot; // siempre empieza desde el primero
    }

    @PostMapping("/solicitar")
    public Map<String, Object> solicitar(@RequestBody Map<String, Object> body) {

        String usuario  = (String) body.get("usuario");
        String problema = (String) body.get("problema");
        int nivel       = Integer.parseInt(body.getOrDefault("nivel", "1").toString());

        if (usuario == null || problema == null) {
            return Map.of("error", "Campos requeridos: usuario, problema, nivel");
        }

        if (nivel < 1 || nivel > 4) {
            return Map.of("error", "Nivel debe ser entre 1 y 4");
        }

        SolicitudSoporteC solicitud = new SolicitudSoporteC(usuario, problema, nivel);

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado", "Chain of Responsibility");
        respuesta.put("usuario",     usuario);
        respuesta.put("problema",    problema);
        respuesta.put("nivel",       nivel);
        respuesta.put("cadena",      "Bot → Agente → Supervisor → Dirección");
        respuesta.put("resultado",   cadena.manejar(solicitud));
        return respuesta;
    }

    @GetMapping("/niveles")
    public Map<String, Object> niveles() {
        return Map.of(
            "nivel1", "Simple — lo resuelve el Bot",
            "nivel2", "Medio — lo resuelve el Agente",
            "nivel3", "Complejo — lo resuelve el Supervisor",
            "nivel4", "Crítico — lo resuelve la Dirección"
        );
    }
}