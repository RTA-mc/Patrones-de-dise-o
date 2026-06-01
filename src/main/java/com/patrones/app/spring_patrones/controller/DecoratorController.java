package com.patrones.app.spring_patrones.controller;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.decorator.ListingBase;
import com.patrones.app.spring_patrones.patrones.estructurales.decorator.ListingD;
import com.patrones.app.spring_patrones.patrones.estructurales.decorator.ParkingDecorator;
import com.patrones.app.spring_patrones.patrones.estructurales.decorator.PiscinaDecorator;
import com.patrones.app.spring_patrones.patrones.estructurales.decorator.WifiDecorator;

@RestController
@RequestMapping("/demo/decorator")
public class DecoratorController {

    @PostMapping("/crear")
    public Map<String, Object> crear(@RequestBody Map<String, Object> body) {

        String nombre = (String) body.get("nombre");
        double precio = Double.parseDouble(body.getOrDefault("precio", "50").toString());

        Object extrasObj    = body.getOrDefault("extras", List.of());
        List<String> extras;
        if (extrasObj instanceof List<?> list) {
            extras = list.stream()
                    .map(Object::toString)
                    .toList();
        } else {
            extras = List.of();
        }

        if (nombre == null) {
            return Map.of("error", "Campos requeridos: nombre, precio, extras");
        }

        // Listing base
        ListingD listing = new ListingBase(nombre, precio);

        // Envolvemos con cada decorador
        for (String extra : extras) {
            switch (extra.toLowerCase()) {
                case "wifi"    -> listing = new WifiDecorator(listing);
                case "piscina" -> listing = new PiscinaDecorator(listing);
                case "parking" -> listing = new ParkingDecorator(listing);
            }
        }

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado",  "Decorator");
        respuesta.put("descripcion",  listing.getDescripcion());
        respuesta.put("precioFinal",  listing.getPrecio());
        respuesta.put("extrasAplica", extras);
        return respuesta;
    }
}