package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.creacionales.builder.Reserva;
import com.patrones.app.spring_patrones.patrones.creacionales.builder.ReservaBuilder;

@RestController
@RequestMapping("/demo/builder")
public class BuilderController {

    @PostMapping("/crear")
    public Map<String, Object> crearReserva(@RequestBody Map<String, Object> body) {

        String huespedNombre = (String) body.get("huespedNombre");
        String alojamiento   = (String) body.get("alojamiento");
        String fechaEntrada  = (String) body.get("fechaEntrada");
        String fechaSalida   = (String) body.get("fechaSalida");

        if (huespedNombre == null || alojamiento == null ||
            fechaEntrada == null || fechaSalida == null) {
            return Map.of("error",
                "Campos obligatorios: huespedNombre, alojamiento, fechaEntrada, fechaSalida");
        }

        ReservaBuilder builder = new ReservaBuilder(
        huespedNombre, alojamiento, fechaEntrada, fechaSalida
        );


        if (Boolean.TRUE.equals(body.get("seguro")))    builder.conSeguro();
        if (Boolean.TRUE.equals(body.get("desayuno")))  builder.conDesayuno();
        if (body.containsKey("cupon"))                  builder.conCupon((String) body.get("cupon"));
        if (body.containsKey("huespedes"))              builder.conHuespedes(
            Integer.parseInt(body.get("huespedes").toString()));
        if (body.containsKey("notas"))                  builder.conNotas((String) body.get("notas"));


        Reserva reserva = builder.build();


        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("resumen",           reserva.getResumen());
        respuesta.put("huespedNombre",     reserva.getHuespedNombre());
        respuesta.put("alojamiento",       reserva.getAlojamiento());
        respuesta.put("fechaEntrada",      reserva.getFechaEntrada());
        respuesta.put("fechaSalida",       reserva.getFechaSalida());
        respuesta.put("huespedes",         reserva.getNumeroHuespedes());
        respuesta.put("seguro",            reserva.isSeguroIncluido());
        respuesta.put("desayuno",          reserva.isDesayunoIncluido());
        respuesta.put("cupon",             reserva.getCuponDescuento());
        respuesta.put("notas",             reserva.getNotasEspeciales());
        return respuesta;
    }
}