package com.patrones.app.spring_patrones.patrones.comportamiento.mediator;


public abstract class Usuario {
    protected MensajeMediator mediador;
    protected String id;
    protected String nombre;
    protected String tipo;
    public Usuario(String id ,String nombre , String tipo, MensajeMediator mediador){
        this.id = id;
        this.nombre = nombre; 
        this.tipo = tipo;
        this.mediador = mediador;
    }
    public abstract void enviar(String mensaje ,String destinatarioId);
    public abstract void recibir(String mensaje ,String remitenteNombre);


    public String getId(){return id;}
    public String getNombre(){return nombre;}
    public String getTipo(){return tipo;}

}
