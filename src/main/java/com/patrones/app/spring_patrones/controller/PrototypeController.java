package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.creacionales.prototype.EstrategiaPreciosBase;
import com.patrones.app.spring_patrones.patrones.creacionales.prototype.PreciosTemporadaAlta;
import com.patrones.app.spring_patrones.patrones.creacionales.prototype.PreciosTemporadaBaja;

@RestController
@RequestMapping("/demo/prototype")
public class PrototypeController {


    private final Map<String, EstrategiaPreciosBase> plantillas = new LinkedHashMap<>();


    public PrototypeController() {
        plantillas.put("temporada-alta", new PreciosTemporadaAlta());
        plantillas.put("temporada-baja", new PreciosTemporadaBaja());
    }


    @GetMapping("/plantillas")
    public Map<String, Object> listarPlantillas() {
        Map<String, Object> resultado = new LinkedHashMap<>();

        plantillas.forEach((id, p) -> {
            Map<String, Object> info = new LinkedHashMap<>();
            info.put("nombre",        p.getNombre());
            info.put("descuento",     p.getDescuento() + "%");
            info.put("limpieza",      "€" + p.getTarifaLimpieza());
            info.put("resumen",       p.getResumen());
            resultado.put(id, info);
        });

        return resultado;
    }


    @PostMapping("/clonar")
    public Map<String, Object> clonar(@RequestBody Map<String, Object> body) {

        String plantillaId = (String) body.get("plantilla");
        double precioBase  = Double.parseDouble(
            body.getOrDefault("precioBase", "100").toString()
        );

        EstrategiaPreciosBase plantilla = plantillas.get(plantillaId);
        if (plantilla == null) {
            return Map.of(
                "error", "Plantilla no encontrada: " + plantillaId,
                "disponibles", plantillas.keySet()
            );
        }


        EstrategiaPreciosBase clon = (EstrategiaPreciosBase) plantilla.clonar();


        if (body.containsKey("nuevoNombre"))
            clon.setNombre((String) body.get("nuevoNombre"));
        if (body.containsKey("descuento"))
            clon.setDescuento(Double.parseDouble(body.get("descuento").toString()));
        if (body.containsKey("tarifaLimpieza"))
            clon.setTarifaLimpieza(Double.parseDouble(body.get("tarifaLimpieza").toString()));


        Map<String, Object> respuesta = new LinkedHashMap<>();
        


        Map<String, Object> originalInfo = new LinkedHashMap<>();
        originalInfo.put("nombre",      plantilla.getNombre());
        originalInfo.put("descuento",   plantilla.getDescuento() + "%");
        originalInfo.put("limpieza",    "€" + plantilla.getTarifaLimpieza());
        originalInfo.put("precioFinal", "€" + plantilla.calcularPrecioFinal(precioBase));
        originalInfo.put("hashCode",    System.identityHashCode(plantilla));
        respuesta.put("original", originalInfo);

        Map<String, Object> clonInfo = new LinkedHashMap<>();
        clonInfo.put("nombre",      clon.getNombre());
        clonInfo.put("descuento",   clon.getDescuento() + "%");
        clonInfo.put("limpieza",    "€" + clon.getTarifaLimpieza());
        clonInfo.put("precioFinal", "€" + clon.calcularPrecioFinal(precioBase));
        clonInfo.put("hashCode",    System.identityHashCode(clon));
        respuesta.put("clon", clonInfo);


        respuesta.put("sonElMismoObjeto", plantilla == clon);

        return respuesta;
    }
}