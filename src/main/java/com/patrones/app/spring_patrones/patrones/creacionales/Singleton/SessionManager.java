package com.patrones.app.spring_patrones.patrones.creacionales.Singleton;
//Singleton



public class SessionManager {
    private static SessionManager instancia;
    private String usuarioActual;
    private final String idInstancia;
    
    private SessionManager(){
        this.idInstancia = "INST-"+ System.currentTimeMillis();
    }
    public static SessionManager getInstancia(){
        if(instancia == null){
            instancia = new SessionManager();
        }
        return instancia;
    }
    public void iniciarSesion(String email){
        this.usuarioActual = email;
    }
    public void cerrarSesion(){
        this.usuarioActual = null;
    }
    public String getUsuarioActual(){return usuarioActual; }

    public String getIdInstancia(){ return idInstancia; }
    public boolean  haySesionActiva(){return usuarioActual != null;}

}

