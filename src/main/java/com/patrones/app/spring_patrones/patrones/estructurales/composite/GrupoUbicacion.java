package com.patrones.app.spring_patrones.patrones.estructurales.composite;

import java.util.ArrayList;
import java.util.List;

public class GrupoUbicacion implements Ubicacion{
    private final String nombre;
    private final String tipo;
    private final List<Ubicacion> hijos = new ArrayList<>(); 
    public GrupoUbicacion(String nombre, String tipo) {
    this.nombre = nombre;
    this.tipo   = tipo;
    }
    public void agregar(Ubicacion ubicacion){
        hijos.add(ubicacion);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int contarListings() {
        return hijos.stream().mapToInt(Ubicacion::contarListings).sum();
    }

    @Override
    public String mostrar(String sangria) {
        StringBuilder sb = new StringBuilder();
        sb.append(sangria).append(" carpeta: ").append(nombre)
          .append(" (").append(tipo).append(") ")
          .append(" — ").append(contarListings()).append(" listings\n ");

        for (Ubicacion hijo : hijos) {
            sb.append(hijo.mostrar(sangria + "  ")).append("\n");
        }
        return sb.toString().trim();
    }
    public List<Ubicacion> getHijos() {
    return hijos;
    }
    
}
