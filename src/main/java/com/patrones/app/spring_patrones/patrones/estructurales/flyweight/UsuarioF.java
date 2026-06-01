package com.patrones.app.spring_patrones.patrones.estructurales.flyweight;


public class UsuarioF {


    private final String nombre;
    private final String email;


    private final UbicacionF ubicacion;

    public UsuarioF(String nombre, String email, UbicacionF ubicacion) {
        this.nombre    = nombre;
        this.email     = email;
        this.ubicacion = ubicacion;
    }

    public String getNombre()         { return nombre; }
    public String getEmail()          { return email; }
    public UbicacionF getUbicacion()  { return ubicacion; }
    public int getUbicacionHashCode() { return System.identityHashCode(ubicacion); }
}