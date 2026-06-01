package com.patrones.app.spring_patrones.controller;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.proxy.ServicioAlojamientoProxy;
;
@RestController
@RequestMapping("/demo/proxy")
public class ProxyController {

    private final ServicioAlojamientoProxy proxy = new ServicioAlojamientoProxy();

    @PostMapping("/acceder")
    public Map<String, Object> acceder(@RequestBody Map<String, String> body) {

        String token         = body.get("token");
        String recurso       = body.get("recurso");
        String alojamientoId = body.get("alojamientoId");

        if (token == null || recurso == null || alojamientoId == null) {
            return Map.of("error",
                "Campos requeridos: token, recurso, alojamientoId");
        }

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado", "Proxy de Seguridad");
        respuesta.put("token",       token);
        respuesta.put("recurso",     recurso);
        respuesta.put("resultado",   proxy.acceder(token, recurso, alojamientoId));
        return respuesta;
    }

    @GetMapping("/tokens")
    public Map<String, Object> listarTokens() {
        return Map.of(
            "descripcion", "Tokens disponibles para probar el proxy",
            "publico",      "sin-token — solo puede ver detalle",
            "autenticado",  "token-huesped — puede ver detalle y precio",
            "privilegiado", "token-anfitrion o token-admin — puede ver todo"
        );
    }
}