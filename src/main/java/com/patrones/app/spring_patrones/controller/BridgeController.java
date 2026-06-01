package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.bridge.ApartamentoB;
import com.patrones.app.spring_patrones.patrones.estructurales.bridge.CasaCompletaB;
import com.patrones.app.spring_patrones.patrones.estructurales.bridge.ListingB;
import com.patrones.app.spring_patrones.patrones.estructurales.bridge.NotificacionB;
import com.patrones.app.spring_patrones.patrones.estructurales.bridge.NotificacionGmailB;
import com.patrones.app.spring_patrones.patrones.estructurales.bridge.NotificacionSMSB;



@RestController
@RequestMapping("/demo/bridge")
public class BridgeController {

    @PostMapping("/publicar")
    public Map<String, Object> publicar(@RequestBody Map<String, String> body) {

        String tipoListing      = body.get("tipoListing");
        String tipoNotificacion = body.get("tipoNotificacion");

        if (tipoListing == null || tipoNotificacion == null) {
            return Map.of("error", "Campos requeridos: tipoListing, tipoNotificacion");
        }

        // Elegimos la implementación
        NotificacionB notificacion = switch (tipoNotificacion.toLowerCase()) {
            case "email" -> (NotificacionB) new NotificacionGmailB();
            case "sms"   -> (NotificacionB) new NotificacionSMSB();
            default -> null;
        };

        if (notificacion == null) {
            return Map.of("error", "tipoNotificacion inválido. Usa: email, sms");
        }

        // Elegimos la abstracción y le inyectamos la implementación
        ListingB listing = switch (tipoListing.toLowerCase()) {
            case "casa"       -> new CasaCompletaB(notificacion);
            case "apartamento"-> new ApartamentoB(notificacion);
            default -> null;
        };

        if (listing == null) {
            return Map.of("error", "tipoListing inválido. Usa: casa, experiencia");
        }

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado",       "Bridge");
        respuesta.put("tipoListing",       tipoListing);
        respuesta.put("tipoNotificacion",  tipoNotificacion);
        respuesta.put("resultado",         listing.publicar());
        return respuesta;
    }
}