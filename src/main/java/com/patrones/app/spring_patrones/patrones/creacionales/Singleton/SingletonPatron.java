package com.patrones.app.spring_patrones.patrones.creacionales.Singleton;

import com.patrones.app.spring_patrones.model.PatronDTO;

public class SingletonPatron {
    public static PatronDTO get(){
        return new PatronDTO(            "singleton",
            "Singleton",
            "creacional",
            "Garantiza una única instancia global de una clase",
            "El patrón Singleton asegura que una clase tenga una sola instancia durante toda la ejecución del programa y provee un punto de acceso global a ella. Se usa cuando necesitas exactamente un objeto que coordine acciones en todo el sistema.",
            "En Airbnb, el gestor de sesión del usuario debe existir una sola vez en memoria. Si se crearan múltiples instancias, diferentes partes de la app podrían tener datos de sesión inconsistentes.",
            "/img/uml/singleton.png",
            CODIGO);
    }
    public static final String CODIGO = """
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
            """;
}
