package com.patrones.app.spring_patrones.patrones.comportamiento.memento;

public class PerfilHost {

    private String nombre;
    private String biografia;
    private String idiomas;
    private String ciudad;

    public PerfilHost(String nombre, String biografia,
                      String idiomas, String ciudad) {
        this.nombre = nombre;
        this.biografia = biografia;
        this.idiomas = idiomas;
        this.ciudad = ciudad;
    }

    // Crea un snapshot del estado actual
    public PerfilMemento guardar() {
        return new PerfilMemento(nombre, biografia, idiomas, ciudad);
    }

    // Restaura el estado desde un snapshot
    public void restaurar(PerfilMemento memento) {
        this.nombre = memento.getNombre();
        this.biografia = memento.getBiografia();
        this.idiomas = memento.getIdiomas();
        this.ciudad = memento.getCiudad();
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setBiografia(String biografia) { this.biografia = biografia; }
    public void setIdiomas(String idiomas) { this.idiomas = idiomas; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getNombre() { return nombre; }
    public String getBiografia() { return biografia; }
    public String getIdiomas() { return idiomas; }
    public String getCiudad() { return ciudad; }
}