package com.patrones.app.spring_patrones.patrones.estructurales.facade;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReservaFacade {
    private final ServicioCalendario servicioCalendario = new ServicioCalendario();
    private final ServicioPago servicioPago = new ServicioPago();
    private final ServicioNotificacion servicioNotificacion = new ServicioNotificacion();
    private final ServicioContrato servicioContrato = new ServicioContrato();
    
    public Map<String, Object> confirmarReserva(String huesped, String alojamiento, String fechaEntrada, String fechaSalida, double monto){
        Map<String , Object> pasos = new LinkedHashMap<>();

        pasos.put("1-paso-fraude", servicioPago.verificarFraude(huesped));
        pasos.put("2-paso-pago", servicioPago.procesarPago(huesped, monto));
        
        pasos.put("3-paso-contrato", servicioContrato.generarContrato(huesped, alojamiento, fechaEntrada, fechaSalida));
        pasos.put("4-paso-firma", servicioContrato.firmarContrato(huesped));

        pasos.put("5-paso-calendario", servicioCalendario.bloquearFechas(alojamiento, fechaEntrada, fechaSalida));

        pasos.put("6-paso-notficarHuesped", servicioNotificacion.notificarHuesped(huesped));
        pasos.put("7-pasos-notificarAnfrition", servicioNotificacion.notificarAnfitrion(alojamiento));

        pasos.put("resultado", "reserva confirmada para: " + huesped);

        return pasos;
    }
}
