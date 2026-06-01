package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.templatemethod.PublicacionApartamento;
import com.patrones.app.spring_patrones.patrones.comportamiento.templatemethod.PublicacionCasa;
import com.patrones.app.spring_patrones.patrones.comportamiento.templatemethod.PublicacionListing;

@RestController
@RequestMapping("/demo/template")
public class TemplateController {

    @PostMapping("/publicar")
    public Map<String, Object> publicar(@RequestBody Map<String, Object> body) {

        String tipo   = (String) body.get("tipo");
        String titulo = (String) body.get("titulo");
        double precio = Double.parseDouble(body.getOrDefault("precio", "0").toString());

        if (tipo == null || titulo == null) {
            return Map.of("error", "Campos requeridos: tipo, titulo, precio");
        }

        PublicacionListing publicacion = switch (tipo.toLowerCase()) {
            case "casa"        -> new PublicacionCasa();
            case "apartamento" -> new PublicacionApartamento();
            default -> null;
        };

        if (publicacion == null) {
            return Map.of("error", "Tipo no válido. Usa: casa, experiencia");
        }

        Map<String, Object> respuesta = new LinkedHashMap<>();
       
        respuesta.put("tipo",        publicacion.getTipo());
        respuesta.put("titulo",      titulo);
        respuesta.put("precio",      precio);
        respuesta.put("resultado",   publicacion.publicar(titulo, precio));
        return respuesta;
    }
}