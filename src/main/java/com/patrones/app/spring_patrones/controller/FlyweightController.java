package com.patrones.app.spring_patrones.controller;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.flyweight.UbicacionF;
import com.patrones.app.spring_patrones.patrones.estructurales.flyweight.UbicacionFactoryF;
import com.patrones.app.spring_patrones.patrones.estructurales.flyweight.UsuarioF;
@RestController
@RequestMapping("/demo/flyweight")
public class FlyweightController {

    private final UbicacionFactoryF factory = new UbicacionFactoryF();
    private final List<UsuarioF> usuarios   = new ArrayList<>();

    @PostMapping("/agregar")
    public Map<String, Object> agregar(@RequestBody Map<String, String> body) {
        String nombre = body.get("nombre");
        String email  = body.get("email");
        String ciudad = body.get("ciudad");
        String pais   = body.get("pais");
        String moneda = body.get("moneda");
        String idioma = body.get("idioma");

        if (nombre == null || email == null || ciudad == null) {
            return Map.of("error", "Campos requeridos: nombre, email, ciudad, pais, moneda, idioma");
        }

        // La fábrica decide si crea o reutiliza
        UbicacionF ubicacion = factory.obtener(ciudad, pais, moneda, idioma);
        usuarios.add(new UsuarioF(nombre, email, ubicacion));

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado",             "Flyweight");
        respuesta.put("nombre",                  nombre);
        respuesta.put("ubicacion",               ubicacion.getResumen());
        respuesta.put("ubicacionHashCode",       System.identityHashCode(ubicacion));
        respuesta.put("totalUsuarios",           usuarios.size());
        respuesta.put("totalUbicacionesCreadas", factory.totalUbicacionesCreadas());
        return respuesta;
    }

    @GetMapping("/cache")
    public Map<String, Object> verCache() {
        return Map.of(
            "patronUsado",           "Flyweight",
            "totalUsuarios",         usuarios.size(),
            "totalUbicacionesCreadas", factory.totalUbicacionesCreadas(),
            "ubicacionesEnCache",    factory.ubicacionesEnCache()
        );
    }

    public List<UsuarioF> getUsuarios() {
        return usuarios;
    }
}