package com.patrones.app.spring_patrones.controller;


import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.strategy.CalculadoraPrecio;
import com.patrones.app.spring_patrones.patrones.comportamiento.strategy.EstrategiaDescuento;
import com.patrones.app.spring_patrones.patrones.comportamiento.strategy.PrecioNormalS;
import com.patrones.app.spring_patrones.patrones.comportamiento.strategy.PrecioTemporadaAltaS;
import com.patrones.app.spring_patrones.patrones.comportamiento.strategy.PrecioUltimoMinuto;

@RestController
@RequestMapping("/demo/strategy")
public class StrategyController {

    @PostMapping("/calcular")
    public Map<String, Object> calcular(@RequestBody Map<String, Object> body) {

        String estrategia = (String) body.get("estrategia");
        double precioBase = Double.parseDouble(body.getOrDefault("precioBase", "0").toString());

        if (estrategia == null) {
            return Map.of("error", "Campos requeridos: estrategia, precioBase");
        }

        EstrategiaDescuento algoritmo = switch (estrategia.toLowerCase()) {
            case "normal"         -> new PrecioNormalS();
            case "temporadaalta"  -> new PrecioTemporadaAltaS();
            case "ultimominuto"   -> new PrecioUltimoMinuto();
            default -> null;
        };

        if (algoritmo == null) {
            return Map.of("error", "Estrategia no válida. Usa: normal, temporadaalta, ultimominuto");
        }

        CalculadoraPrecio calculadora = new CalculadoraPrecio(algoritmo);

        Map<String, Object> respuesta = new LinkedHashMap<>();
        
        respuesta.put("estrategia",   calculadora.getEstrategiaNombre());
        respuesta.put("descripcion",  calculadora.getEstrategiaDescripcion());
        respuesta.put("precioBase",   "$" + precioBase);
        respuesta.put("precioFinal",  "$" + calculadora.calcularPrecio(precioBase));
        return respuesta;
    }

    @GetMapping("/estrategias")
    public Map<String, Object> listarEstrategias() {
        return Map.of(
            "normal",        "Sin modificaciones al precio base",
            "temporadaalta", "Recargo del 30% por temporada alta",
            "ultimominuto",  "Descuento del 20% por reserva de último minuto"
        );
    }
}