package com.patrones.app.spring_patrones.patrones.estructurales.flyweight;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class UbicacionFactoryF {


    private final Map<String, UbicacionF> cache = new HashMap<>();

    public UbicacionF obtener(String ciudad, String pais, String moneda, String idioma) {
        String clave = ciudad + "-" + pais;

        if (!cache.containsKey(clave)) {
            cache.put(clave, new UbicacionF(ciudad, pais, moneda, idioma));
            System.out.println("[Flyweight] Creando nueva ubicación: " + clave);
        } else {
            System.out.println("[Flyweight] Reutilizando ubicación: " + clave);
        }

        return cache.get(clave);
    }

    public int totalUbicacionesCreadas() {
        return cache.size();
    }

    public Set<String> ubicacionesEnCache() {
        return cache.keySet();
    }
}