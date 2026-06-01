package com.patrones.app.spring_patrones.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.comand.Comando;
import com.patrones.app.spring_patrones.patrones.comportamiento.comand.HistorialComandos;
import com.patrones.app.spring_patrones.patrones.comportamiento.comand.ListingC;
import com.patrones.app.spring_patrones.patrones.comportamiento.comand.SetDescripcionComando;
import com.patrones.app.spring_patrones.patrones.comportamiento.comand.SetPrecioComando;
import com.patrones.app.spring_patrones.patrones.comportamiento.comand.SetTituloComando;


@RestController
@RequestMapping("/demo/command")
public class CommandController {

    private final ListingC listing = new ListingC(
        "Apartamento en Bogotá",
        "Amplio y luminoso",
        150000
    );
    private final HistorialComandos historial = new HistorialComandos();

    @GetMapping("/estado")
    public Map<String, Object> getEstado() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("titulo", listing.getTitulo());
        respuesta.put("descripcion", listing.getDescripcion());
        respuesta.put("precio", listing.getPrecio());
        respuesta.put("log", historial.getLog());
        respuesta.put("puedeDeshacer", historial.tieneHistorial());
        return respuesta;
    }

    @PostMapping("/editar")
    public Map<String, Object> editar(@RequestBody Map<String, String> body) {
        String campo = body.get("campo");
        String valor = body.get("valor");

        if (campo == null || valor == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Faltan campos: campo, valor");
            return error;
        }

        Comando comando = switch (campo.toLowerCase()) {
            case "titulo"      -> new SetTituloComando(listing, valor);
            case "descripcion" -> new SetDescripcionComando(listing, valor);
            case "precio"      -> new SetPrecioComando(listing, Double.parseDouble(valor));
            default -> null;
        };

        if (comando == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Campo no válido: " + campo);
            return error;
        }

        String resultado = historial.ejecutar(comando);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("resultado", resultado);
        respuesta.put("titulo", listing.getTitulo());
        respuesta.put("descripcion", listing.getDescripcion());
        respuesta.put("precio", listing.getPrecio());
        respuesta.put("log", historial.getLog());
        respuesta.put("puedeDeshacer", historial.tieneHistorial());
        return respuesta;
    }

    @PostMapping("/deshacer")
    public Map<String, Object> deshacer() {
        String resultado = historial.deshacer();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("resultado", resultado);
        respuesta.put("titulo", listing.getTitulo());
        respuesta.put("descripcion", listing.getDescripcion());
        respuesta.put("precio", listing.getPrecio());
        respuesta.put("log", historial.getLog());
        respuesta.put("puedeDeshacer", historial.tieneHistorial());
        return respuesta;
    }

    @PostMapping("/reset")
    public Map<String, Object> reset() {
        listing.setTitulo("Apartamento en Bogotá");
        listing.setDescripcion("Amplio y luminoso");
        listing.setPrecio(150000);
        historial.getLog().clear();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("resultado", "Listing restaurado al estado inicial");
        respuesta.put("titulo", listing.getTitulo());
        respuesta.put("descripcion", listing.getDescripcion());
        respuesta.put("precio", listing.getPrecio());
        return respuesta;
    }
}