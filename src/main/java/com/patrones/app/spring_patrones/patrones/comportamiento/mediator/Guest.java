package com.patrones.app.spring_patrones.patrones.comportamiento.mediator;

public class Guest extends Usuario{
    
    public Guest(String nombre, String id , MensajeMediator mediador){
        super(nombre, id, "guest", mediador);
        
    }
    
    @Override
    public void enviar(String mensaje, String destinatarioId) {
        mediador.enviarMensaje(mensaje, this.id , destinatarioId);
    }

    @Override
    public void recibir(String mensaje, String remitenteNombre) {
        System.out.println("GUEST: "+ nombre +" recibio de: " +remitenteNombre+ " : "+ mensaje);
    }
    
}
