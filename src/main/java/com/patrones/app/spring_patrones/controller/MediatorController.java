package com.patrones.app.spring_patrones.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.mediator.AirbnbChat;
import com.patrones.app.spring_patrones.patrones.comportamiento.mediator.Guest;
import com.patrones.app.spring_patrones.patrones.comportamiento.mediator.Host;
import com.patrones.app.spring_patrones.patrones.comportamiento.mediator.Usuario;

@RestController
@RequestMapping("/demo/mediator")
public class MediatorController {

    private final AirbnbChat chat = new AirbnbChat();
    

    public MediatorController() {
    
    Usuario host = new Host("host-1", "Carlos (Host)", chat);
    chat.registrarUsuario(host);
    Usuario guest = new Guest("guest-1", "María (Guest)", chat);
    chat.registrarUsuario(guest);
    }

    @GetMapping("/historial")
    public List<Map<String, String>> getHistorial() {
        return chat.getHistorial();
    }
    @GetMapping("/usuarios")
    public List<String> getUsuarios() {
    return chat.getUsuarios().values()
        .stream()
        .map(u -> u.getId() + " - " + u.getNombre())
        .toList();
}

    @PostMapping("/enviar")
    public Map<String, Object> enviarMensaje(@RequestBody Map<String, String> body) {
        String mensaje = body.get("mensaje");
        String remitenteId = body.get("remitenteId");
        String destinatarioId = body.get("destinatarioId");

        if (mensaje == null || remitenteId == null || destinatarioId == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Faltan campos: mensaje, remitenteId, destinatarioId");
            return error;
        }

        chat.enviarMensaje(mensaje, remitenteId, destinatarioId);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("historial", chat.getHistorial());
        return respuesta;
    }

    @PostMapping("/reset")
    public Map<String, Object> reset() {
        chat.getHistorial().clear();
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        respuesta.put("mensaje", "Chat reiniciado");
        return respuesta;
    }
}