package com.patrones.app.spring_patrones.patrones.comportamiento.mediator;

public interface  MensajeMediator {
    void enviarMensaje(String mensaje, String remitenteId, String destinatarioId);
    void registrarUsuario(Usuario usuario);
    
}
