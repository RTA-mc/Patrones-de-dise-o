package com.patrones.app.spring_patrones.patrones.comportamiento.mediator;

public class Host extends Usuario {

    public Host(String id, String nombre, MensajeMediator mediador) {
        super(id, nombre, "host", mediador);
    }
    
    @Override
    public void enviar(String mensaje, String destinatarioId) {
      mediador.enviarMensaje(mensaje, this.id , destinatarioId);
    }

    @Override
    public void recibir(String mensaje, String remitenteNombre) {
        System.out.println("GUST : " + nombre + "recibio de "+ remitenteNombre+" : "+ mensaje);
        
    }
    
}
