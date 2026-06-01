package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.facade.ReservaFacade;


@RestController
@RequestMapping("/demo/facade")
public class FacadeController {

    private final ReservaFacade reserva = new ReservaFacade();
    @PostMapping("/confirmar")
    public Map<String , Object> confirmar(@RequestBody Map<String, Object> body){
        String huesped = (String) body.get("huesped");
        String alojamiento = (String) body.get("alojamiento");
        String fechaEntrada =(String) body.get("fechaEntrada");
        String fechaSalida =(String) body.get("fechaSalida");
        double monto = Double.parseDouble(body.getOrDefault("monto", "0").toString());
        if(huesped ==null || alojamiento == null ||fechaEntrada==null || fechaSalida == null){
            return Map.of("error", "Campos requeridos huesped, alojamiento, fechaEntrada, fechaSalida");
        }
        
        Map<String,Object> respuesta = new LinkedHashMap<>();
        respuesta.put("descripcion", "El ususario solo llama  confirmarReserva()"+ " El facade cordina los 4 subsistemas");
        respuesta.putAll(reserva.confirmarReserva(huesped, alojamiento, fechaEntrada, fechaSalida, monto));
        return respuesta;
        

    }
    
    
}
