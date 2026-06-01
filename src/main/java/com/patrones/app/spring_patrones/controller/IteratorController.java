package com.patrones.app.spring_patrones.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.iterator.ColeccionReservas;
import com.patrones.app.spring_patrones.patrones.comportamiento.iterator.FiltroReservaIterator;
import com.patrones.app.spring_patrones.patrones.comportamiento.iterator.ReservaI;

@RestController
@RequestMapping("/demo/iterator")
public class IteratorController {

    private final ColeccionReservas coleccion = new ColeccionReservas();

    @GetMapping("/todas")
    public Map<String, Object> getTodas() {
        FiltroReservaIterator iterator = coleccion.crearIterator(null, null, 0);
        return construirRespuesta(iterator);
    }

    @PostMapping("/buscar")
    public Map<String, Object> buscar(@RequestBody Map<String, String> body) {
        String estado = body.get("estado");
        String mes = body.get("mes");
        double calificacionMin = body.get("calificacionMin") != null
            ? Double.parseDouble(body.get("calificacionMin")) : 0;

        FiltroReservaIterator iterator = coleccion.crearIterator(estado, mes, calificacionMin);
        return construirRespuesta(iterator);
    }

    private Map<String, Object> construirRespuesta(FiltroReservaIterator iterator) {
        List<Map<String, Object>> resultados = new ArrayList<>();

        while (iterator.hasNext()) {
            ReservaI reserva = iterator.next();
            Map<String, Object> item = new HashMap<>();
            item.put("id", reserva.getId());
            item.put("huesped", reserva.getHuesped());
            item.put("alojamiento", reserva.getAlojamiento());
            item.put("estado", reserva.getEstado());
            item.put("mes", reserva.getMes());
            item.put("total", reserva.getTotal());
            item.put("calificacionHuesped", reserva.getCalificacionHuesped());
            resultados.add(item);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("totalEncontradas", iterator.totalEncontradas());
        respuesta.put("totalColeccion", coleccion.totalReservas());
        respuesta.put("totalIngresos", iterator.totalIngresos());
        respuesta.put("resultados", resultados);
        return respuesta;
    }
}