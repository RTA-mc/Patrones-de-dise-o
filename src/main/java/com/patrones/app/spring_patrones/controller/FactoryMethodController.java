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

import com.patrones.app.spring_patrones.patrones.creacionales.factorymethod.AlojamientoFactory;
import com.patrones.app.spring_patrones.patrones.creacionales.factorymethod.ApartamentoFactory;
import com.patrones.app.spring_patrones.patrones.creacionales.factorymethod.CasaFactory;
import com.patrones.app.spring_patrones.patrones.creacionales.factorymethod.Listing;




@RestController
@RequestMapping("/demo/factorymethod")
public class FactoryMethodController {
    private AlojamientoFactory getFactory(String tipo){
        return switch (tipo.toLowerCase()){
            case "apartamento" -> new ApartamentoFactory();
            case "casa" -> new CasaFactory();
            default -> throw new IllegalArgumentException("Tipo no valido "+ tipo);
        } ;
    }
    @GetMapping("/tipos")
    public List <Map<String, String>> getTipos(){
        List<Map<String, String > > tipos = new ArrayList<>();
        for (String tipo : List.of("apartamento", "casa")){
            AlojamientoFactory factory = getFactory(tipo);
            Listing listing = factory.crearListing("casa", "Requiere: fotos de cada habitación, patio o jardín, capacidad máxima de huéspedes");
            Map<String, String> info = new HashMap<>();
            info.put("tipo", listing.getTipo());
            info.put("requisitos", listing.getRequisitos());
            tipos.add(info);
        }
        return tipos;
    }
    @PostMapping("/crear")
    public Map<String, Object> crearListing(@RequestBody Map<String, String> body) {
        String tipo = body.get("tipo");
        String titulo = body.get("titulo");
        String descripcion = body.get("descripcion");

        if (tipo == null || titulo == null || descripcion == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Faltan campos: tipo, titulo, descripcion");
            return error;
        }

        try {
            AlojamientoFactory factory = getFactory(tipo);
            Listing listing = factory.crearListing(titulo, descripcion);

            Map<String, Object> respuesta = new HashMap<>();
            respuesta.put("tipo", listing.getTipo());
            respuesta.put("titulo", listing.getTitulo());
            respuesta.put("descripcion", listing.getDescripcion());
            respuesta.put("requisitos", listing.getRequisitos());
            respuesta.put("validacion", listing.validar());
            respuesta.put("guardado", listing.guardar());
            respuesta.put("fabricaUsada", factory.getClass().getSimpleName());
            return respuesta;

        } catch (IllegalArgumentException e) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", e.getMessage());
            return error;
        }
    }
}