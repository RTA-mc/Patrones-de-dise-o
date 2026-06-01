package com.patrones.app.spring_patrones.patrones.comportamiento.comand;

public class ListingC {

    private String titulo;
    private String descripcion;
    private double precio;

    public ListingC(String titulo, String descripcion, double precio) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return "Titulo: " + titulo + " | Descripcion: " + descripcion + " | Precio: $" + precio;
    }
}