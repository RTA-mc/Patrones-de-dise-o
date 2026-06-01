package com.patrones.app.spring_patrones.patrones.comportamiento.memento;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PerfilMemento {

    private final String nombre;
    private final String biografia;
    private final String idiomas;
    private final String ciudad;
    private final String fechaGuardado;

    public PerfilMemento(String nombre, String biografia,
                         String idiomas, String ciudad) {
        this.nombre = nombre;
        this.biografia = biografia;
        this.idiomas = idiomas;
        this.ciudad = ciudad;
        this.fechaGuardado = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public String getNombre() { return nombre; }
    public String getBiografia() { return biografia; }
    public String getIdiomas() { return idiomas; }
    public String getCiudad() { return ciudad; }
    public String getFechaGuardado() { return fechaGuardado; }
}