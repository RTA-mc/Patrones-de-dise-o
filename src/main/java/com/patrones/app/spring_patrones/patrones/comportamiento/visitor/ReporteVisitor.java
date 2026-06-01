package com.patrones.app.spring_patrones.patrones.comportamiento.visitor;

import java.util.ArrayList;
import java.util.List;

public class ReporteVisitor implements ListingVisitor {

    private double totalIngresos = 0;
    private double precioMasAlto = 0;
    private String listingMasCaro = "";
    private final List<String> detalles = new ArrayList<>();

    @Override
    public String visitar(ApartamentoV apartamento) {
        totalIngresos += apartamento.getPrecioPorNoche();

        if (apartamento.getPrecioPorNoche() > precioMasAlto) {
            precioMasAlto = apartamento.getPrecioPorNoche();
            listingMasCaro = apartamento.getTitulo();
        }

        String detalle = "Apartamento: " + apartamento.getTitulo()
            + " | $" + apartamento.getPrecioPorNoche()
            + " | " + apartamento.getHabitaciones() + " hab, "
            + apartamento.getBaños() + " baños"
            + " | " + apartamento.getUbicacion();

        detalles.add(detalle);
        return detalle;
    }

    @Override
    public String visitar(ExperienciaV experiencia) {
        totalIngresos += experiencia.getPrecioPorNoche();

        if (experiencia.getPrecioPorNoche() > precioMasAlto) {
            precioMasAlto = experiencia.getPrecioPorNoche();
            listingMasCaro = experiencia.getTitulo();
        }

        String detalle = "Experiencia: " + experiencia.getTitulo()
            + " | $" + experiencia.getPrecioPorNoche()
            + " | Cupo: " + experiencia.getCupoMaximo()
            + " | Duración: " + experiencia.getDuracionHoras() + "h"
            + " | " + experiencia.getUbicacion();

        detalles.add(detalle);
        return detalle;
    }

    public double getTotalIngresos() { return totalIngresos; }
    public double getPrecioMasAlto() { return precioMasAlto; }
    public String getListingMasCaro() { return listingMasCaro; }
    public List<String> getDetalles() { return detalles; }
    public double getPromedioPrecios() {
        return detalles.isEmpty() ? 0 : totalIngresos / detalles.size();
    }
}