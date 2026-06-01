package com.patrones.app.spring_patrones.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patrones.app.spring_patrones.patrones.estructurales.composite.GrupoUbicacion;
import com.patrones.app.spring_patrones.patrones.estructurales.composite.ListingIndividual;
import com.patrones.app.spring_patrones.patrones.estructurales.composite.Ubicacion;



@RestController
@RequestMapping("/demo/composite")
public class CompositeController {

    // Construye el árbol una sola vez
    private final GrupoUbicacion raiz = construirArbol();

    private GrupoUbicacion construirArbol() {

        // Listings individuales — hojas
        ListingIndividual casa1    = new ListingIndividual("Casa Sol",        "Casa completa");
        ListingIndividual apto1    = new ListingIndividual("Apto Gran Via",   "Apartamento");
        ListingIndividual hab1     = new ListingIndividual("Hab. Gotico",     "Habitacion privada");
        ListingIndividual casa2    = new ListingIndividual("Casa Playa",      "Casa completa");
        ListingIndividual apto2    = new ListingIndividual("Apto Miraflores", "Apartamento");
        ListingIndividual hab2     = new ListingIndividual("Hab. Barranco",   "Habitacion privada");

        // Barrios
        GrupoUbicacion centro   = new GrupoUbicacion("Centro",     "Barrio");
        GrupoUbicacion gotico   = new GrupoUbicacion("Gotico",     "Barrio");
        GrupoUbicacion miraflores = new GrupoUbicacion("Miraflores", "Barrio");
        GrupoUbicacion barranco   = new GrupoUbicacion("Barranco",   "Barrio");

        centro.agregar(casa1);
        centro.agregar(apto1);
        gotico.agregar(hab1);
        miraflores.agregar(apto2);
        barranco.agregar(casa2);
        barranco.agregar(hab2);

        // Ciudades
        GrupoUbicacion madrid = new GrupoUbicacion("Madrid", "Ciudad");
        GrupoUbicacion barcelona = new GrupoUbicacion("Barcelona", "Ciudad");
        GrupoUbicacion lima = new GrupoUbicacion("Lima", "Ciudad");

        madrid.agregar(centro);
        barcelona.agregar(gotico);
        lima.agregar(miraflores);
        lima.agregar(barranco);

        // Paises
        GrupoUbicacion espana = new GrupoUbicacion("España", "Pais");
        GrupoUbicacion peru   = new GrupoUbicacion("Peru",   "Pais");

        espana.agregar(madrid);
        espana.agregar(barcelona);
        peru.agregar(lima);

        // Raiz
        GrupoUbicacion mundo = new GrupoUbicacion("Mundo", "Raiz");
        mundo.agregar(espana);
        mundo.agregar(peru);

        return mundo;
    }

    // Ver árbol completo
    @GetMapping("/arbol")
    public Map<String, Object> verArbol() {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado",    "Composite");
        respuesta.put("totalListings",  raiz.contarListings());
        respuesta.put("estructura",     raiz.mostrar(""));
        return respuesta;
    }

    // Contar listings de un nodo específico
    @GetMapping("/contar/{nombre}")
    public Map<String, Object> contar(@PathVariable String nombre) {
        Ubicacion encontrada = buscar(raiz, nombre);

        if (encontrada == null) {
            return Map.of("error", "No encontrado: " + nombre);
        }

        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("patronUsado",   "Composite");
        respuesta.put("nodo",          nombre);
        respuesta.put("totalListings", encontrada.contarListings());
        respuesta.put("detalle",       encontrada.mostrar(""));
        return respuesta;
    }

    // Búsqueda recursiva por nombre
    private Ubicacion buscar(Ubicacion nodo, String nombre) {
        if (nodo.getNombre().equalsIgnoreCase(nombre)) return nodo;
        if (nodo instanceof GrupoUbicacion grupo) {
            for (Ubicacion hijo : grupo.getHijos()) {
                Ubicacion resultado = buscar(hijo, nombre);
                if (resultado != null) return resultado;
            }
        }
        return null;
    }
}