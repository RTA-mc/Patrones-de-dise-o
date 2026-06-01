package com.patrones.app.spring_patrones.patrones.comportamiento.templatemethod;


public abstract class PublicacionListing {

    public final String publicar(String titulo, double precio) {
        String paso1 = validarDatos(titulo, precio);
        String paso2 = calcularPrecio(precio);
        String paso3 = generarDescripcion(titulo);
        String paso4 = publicarListing(titulo);

        return paso1 + " | " + paso2 + " | " + paso3 + " | " + paso4;
    }

    // Pasos que cada subclase implementa
    protected abstract String validarDatos(String titulo, double precio);
    protected abstract String calcularPrecio(double precio);
    protected abstract String generarDescripcion(String titulo);
    protected abstract String publicarListing(String titulo);

    public abstract String getTipo();
}