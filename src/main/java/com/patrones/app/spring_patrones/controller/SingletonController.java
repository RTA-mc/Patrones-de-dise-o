package com.patrones.app.spring_patrones.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.creacionales.Singleton.SessionManager;





@RestController
@RequestMapping("/demo/singleton")
public class SingletonController {
    @GetMapping("/estado")
    public Map<String, Object> getEstado() {
        SessionManager sesion = SessionManager.getInstancia();
    
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idInstancia", sesion.getIdInstancia() != null ? sesion.getIdInstancia() : "");
        respuesta.put("usuarioActual", sesion.getUsuarioActual() != null ? sesion.getUsuarioActual() : "");
        respuesta.put("sesionActiva", sesion.haySesionActiva());
        return respuesta;
    }
    @PostMapping("/login")
    public Map<String , Object> login(@RequestBody Map<String , Object> body) {
        SessionManager sesion = SessionManager.getInstancia();
        sesion.iniciarSesion((String) body.get("email"));
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("idInstancia", sesion.getIdInstancia());
        respuesta.put("usuarioActual", sesion.getUsuarioActual());
        respuesta.put("sesionActiva", true);
        respuesta.put("mensaje", "Sesion Iniciada-Activa..");
        return respuesta;

    }
    @PostMapping("/logout")
    public  Map<String , Object> logout(){
        SessionManager sesion = SessionManager.getInstancia();
        sesion.cerrarSesion();
        Map<String,Object> respuesta = new HashMap<>();
        respuesta.put("idInstacia", sesion.getIdInstancia());
        respuesta.put("usuarioActual", "");
        respuesta.put("sesionActiva", null);
        respuesta.put("mesaje", "Sesion cerrada");
        return respuesta;

    }
    
}
