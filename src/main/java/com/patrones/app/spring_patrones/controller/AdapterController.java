package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.adapter.AdaptadorJSONaXML;
import com.patrones.app.spring_patrones.patrones.estructurales.adapter.DatosJSON;
@RestController
@RequestMapping("/demo/adapter")
public class AdapterController {

    private final AdaptadorJSONaXML adaptador = new AdaptadorJSONaXML();

    @PostMapping("/analizar")
    public Map<String, Object> analizar(@RequestBody Map<String, Object> body) {

        String empresa = (String) body.get("empresa");
        double precio  = Double.parseDouble(body.getOrDefault("precio", "0").toString());
        int volumen    = Integer.parseInt(body.getOrDefault("volumen", "0").toString());

        if (empresa == null) {
            return Map.of("error", "Campos requeridos: empresa, precio, volumen");
        }

        DatosJSON datosJSON = new DatosJSON(empresa, precio, volumen);

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado",    "Adapter");
        respuesta.put("formatoEntrada", "JSON");
        respuesta.put("formatoSalida",  "XML");
        respuesta.put("jsonOriginal",   datosJSON.getDatosEnJSON());
        respuesta.put("resultado",      adaptador.adaptar(datosJSON));
        return respuesta;
    }
}