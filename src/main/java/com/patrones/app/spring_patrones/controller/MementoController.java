package com.patrones.app.spring_patrones.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.memento.HistorialPerfil;
import com.patrones.app.spring_patrones.patrones.comportamiento.memento.PerfilHost;
import com.patrones.app.spring_patrones.patrones.comportamiento.memento.PerfilMemento;

@RestController
@RequestMapping("/demo/memento")
public class MementoController {

    private final PerfilHost perfil = new PerfilHost(
        "Carlos Mendoza",
        "Host desde 2019, amante de los viajes",
        "Español, Inglés",
        "Bogotá"
    );
    private final HistorialPerfil historial = new HistorialPerfil();

    public MementoController() {
       
        historial.guardarSnapshot(perfil.guardar());
    }

    @GetMapping("/estado")
    public Map<String, Object> getEstado() {
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("nombre", perfil.getNombre());
        respuesta.put("biografia", perfil.getBiografia());
        respuesta.put("idiomas", perfil.getIdiomas());
        respuesta.put("ciudad", perfil.getCiudad());
        respuesta.put("totalSnapshots", historial.totalSnapshots());
        respuesta.put("snapshots", historial.getResumenSnapshots());
        return respuesta;
    }

    @PostMapping("/editar")
    public Map<String, Object> editar(@RequestBody Map<String, String> body) {
        // Guarda snapshot antes de editar
        historial.guardarSnapshot(perfil.guardar());

        if (body.get("nombre") != null) perfil.setNombre(body.get("nombre"));
        if (body.get("biografia") != null) perfil.setBiografia(body.get("biografia"));
        if (body.get("idiomas") != null) perfil.setIdiomas(body.get("idiomas"));
        if (body.get("ciudad") != null) perfil.setCiudad(body.get("ciudad"));

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Perfil actualizado — snapshot guardado");
        respuesta.put("nombre", perfil.getNombre());
        respuesta.put("biografia", perfil.getBiografia());
        respuesta.put("idiomas", perfil.getIdiomas());
        respuesta.put("ciudad", perfil.getCiudad());
        respuesta.put("totalSnapshots", historial.totalSnapshots());
        return respuesta;
    }

    @PostMapping("/restaurar")
    public Map<String, Object> restaurar(@RequestBody Map<String, String> body) {
        if (body.get("indice") == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Falta el campo: indice");
            return error;
        }

        int indice = Integer.parseInt(body.get("indice"));
        PerfilMemento snapshot = historial.getSnapshot(indice);

        if (snapshot == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("error", "Snapshot no encontrado en indice: " + indice);
            return error;
        }

        perfil.restaurar(snapshot);

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Perfil restaurado al snapshot " + indice
            + " — guardado el " + snapshot.getFechaGuardado());
        respuesta.put("nombre", perfil.getNombre());
        respuesta.put("biografia", perfil.getBiografia());
        respuesta.put("idiomas", perfil.getIdiomas());
        respuesta.put("ciudad", perfil.getCiudad());
        return respuesta;
    }
}