package com.patrones.app.spring_patrones.patrones.comportamiento.comand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HistorialComandos {

    private final Stack<Comando> historial = new Stack<>();
    private final List<String> log = new ArrayList<>();

    public String ejecutar(Comando comando) {
        String resultado = comando.ejecutar();
        historial.push(comando);
        log.add("EJECUTADO: " + comando.getDescripcion());
        return resultado;
    }

    public String deshacer() {
        if (historial.isEmpty()) {
            return "No hay acciones para deshacer";
        }
        Comando ultimo = historial.pop();
        String resultado = ultimo.deshacer();
        log.add("DESHECHO: " + ultimo.getDescripcion());
        return resultado;
    }

    public List<String> getLog() { return log; }
    public boolean tieneHistorial() { return !historial.isEmpty(); }
    public int totalAcciones() { return historial.size(); }
}