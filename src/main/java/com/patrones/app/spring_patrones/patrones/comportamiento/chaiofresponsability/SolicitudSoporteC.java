package com.patrones.app.spring_patrones.patrones.comportamiento.chaiofresponsability;

public class SolicitudSoporteC {
    private final String usuario;
    private final String problema;
    private final int nivel; 
    public SolicitudSoporteC(String usuario, String problema, int nivel) {
        this.usuario  = usuario;
        this.problema = problema;
        this.nivel    = nivel;
    }

    public String getUsuario()  { return usuario; }
    public String getProblema() { return problema; }
    public int getNivel()       { return nivel; }
}