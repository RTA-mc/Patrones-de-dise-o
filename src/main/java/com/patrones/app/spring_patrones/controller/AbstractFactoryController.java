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

import com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory.ColombiaFactory;
import com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory.EspanaFactory;
import com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory.MexicoFactory;
import com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory.Notificacion;
import com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory.Pago;
import com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory.RegionFactory;


@RestController
@RequestMapping("/demo/abstractfactory")
public class AbstractFactoryController {

    private RegionFactory getFactory(String region) {
        return switch (region.toLowerCase()) {
            case "colombia" -> new ColombiaFactory();
            case "mexico"   -> new MexicoFactory();
            case "espana"   -> new EspanaFactory();
            default -> throw new IllegalArgumentException("Región no válida: " + region);
        };
    }

    @GetMapping("/regiones")
    public List<Map<String, String>> getRegiones() {
        List<Map<String, String>> regiones = new ArrayList<>();
        for (String r : List.of("colombia", "mexico", "espana")) {
            RegionFactory factory = getFactory(r);
            Map<String, String> info = new HashMap<>();
            info.put("region", factory.getRegion());
            info.put("moneda", factory.crearPago().getMoneda());
            info.put("metodoPago", factory.crearPago().getMetodo());
            info.put("canalNotificacion", factory.crearNotificacion().getCanal());
            regiones.add(info);
        }
        return regiones;
    }

    @PostMapping("/procesar")
    public Map<String, Object> procesarReserva(@RequestBody Map<String, String> body) {
        String region = body.get("region");
        String montoStr = body.get("monto");

        if (region == null || montoStr == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Faltan campos: region, monto");
            return error;
        }

        try {
            RegionFactory factory = getFactory(region);
            Pago pago = factory.crearPago();
            Notificacion notificacion = factory.crearNotificacion();
            double monto = Double.parseDouble(montoStr);

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("region", factory.getRegion());
            respuesta.put("fabricaUsada", factory.getClass().getSimpleName());
            respuesta.put("pago", pago.procesar(monto));
            respuesta.put("notificacion", notificacion.enviar("Tu reserva fue confirmada"));
            respuesta.put("moneda", pago.getMoneda());
            respuesta.put("canal", notificacion.getCanal());
            return respuesta;

        } catch (IllegalArgumentException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getMessage());
            return error;
        }
    }
}