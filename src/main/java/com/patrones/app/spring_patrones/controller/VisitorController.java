package com.patrones.app.spring_patrones.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.comportamiento.visitor.ApartamentoV;
import com.patrones.app.spring_patrones.patrones.comportamiento.visitor.ExperienciaV;
import com.patrones.app.spring_patrones.patrones.comportamiento.visitor.ListingV;
import com.patrones.app.spring_patrones.patrones.comportamiento.visitor.ReporteVisitor;

@RestController
@RequestMapping("/demo/visitor")
public class VisitorController {


    private List<ListingV> getListingsEjemplo() {
        List<ListingV> listings = new ArrayList<>();
        listings.add(new ApartamentoV("Loft en Chapinero", 180000, "Bogotá", 2, 1));
        listings.add(new ApartamentoV("Penthouse en Poblado", 350000, "Medellín", 3, 2));
        listings.add(new ExperienciaV("Tour gastronómico", 85000, "Bogotá", 8, 3));
        listings.add(new ExperienciaV("Senderismo Cocora", 120000, "Salento", 12, 5));
        listings.add(new ApartamentoV("Studio en Cartagena", 220000, "Cartagena", 1, 1));
        return listings;
    }

    @GetMapping("/reporte")
    public Map<String, Object> generarReporte() {
        List<ListingV> listings = getListingsEjemplo();
        ReporteVisitor visitor = new ReporteVisitor();


        List<String> detalles = new ArrayList<>();
        for (ListingV listing : listings) {
            detalles.add(listing.aceptar(visitor));
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("detalles", detalles);
        respuesta.put("totalListings", listings.size());
        respuesta.put("totalIngresos", visitor.getTotalIngresos());
        respuesta.put("promedioPrecios", visitor.getPromedioPrecios());
        respuesta.put("listingMasCaro", visitor.getListingMasCaro());
        respuesta.put("precioMasAlto", visitor.getPrecioMasAlto());
        return respuesta;
    }

    @PostMapping("/analizar")
    public Map<String, Object> analizarListings(@RequestBody List<Map<String, Object>> body) {
        List<ListingV> listings = new ArrayList<>();

        for (Map<String, Object> item : body) {
            String tipo = (String) item.get("tipo");
            String titulo = (String) item.get("titulo");
            String ubicacion = (String) item.get("ubicacion");
            double precio = Double.parseDouble(item.get("precio").toString());

            if ("apartamento".equals(tipo)) {
                int hab = Integer.parseInt(item.get("habitaciones").toString());
                int ban = Integer.parseInt(item.get("banos").toString());
                listings.add(new ApartamentoV(titulo, precio, ubicacion, hab, ban));
            } else if ("experiencia".equals(tipo)) {
                int cupo = Integer.parseInt(item.get("cupo").toString());
                int duracion = Integer.parseInt(item.get("duracion").toString());
                listings.add(new ExperienciaV(titulo, precio, ubicacion, cupo, duracion));
            }
        }

        ReporteVisitor visitor = new ReporteVisitor();
        for (ListingV listing : listings) {
            listing.aceptar(visitor);
        }

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("detalles", visitor.getDetalles());
        respuesta.put("totalListings", listings.size());
        respuesta.put("totalIngresos", visitor.getTotalIngresos());
        respuesta.put("promedioPrecios", visitor.getPromedioPrecios());
        respuesta.put("listingMasCaro", visitor.getListingMasCaro());
        return respuesta;
    }
}