package com.patrones.app.spring_patrones.patrones.comportamiento.memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistorialPerfil {

    private final List<PerfilMemento> snapshots = new ArrayList<>();

    public void guardarSnapshot(PerfilMemento memento) {
        snapshots.add(memento);
    }

    public PerfilMemento getSnapshot(int indice) {
        if (indice < 0 || indice >= snapshots.size()) return null;
        return snapshots.get(indice);
    }

    public PerfilMemento getUltimo() {
        if (snapshots.isEmpty()) return null;
        return snapshots.get(snapshots.size() - 1);
    }

    public List<Map<String, String>> getResumenSnapshots() {
        List<Map<String, String>> resumen = new ArrayList<>();
        for (int i = 0; i < snapshots.size(); i++) {
            PerfilMemento snap = snapshots.get(i);
            Map<String, String> item = new HashMap<>();
            item.put("indice", String.valueOf(i));
            item.put("nombre", snap.getNombre());
            item.put("ciudad", snap.getCiudad());
            item.put("fechaGuardado", snap.getFechaGuardado());
            resumen.add(item);
        }
        return resumen;
    }

    public boolean tieneSnapshots() { return !snapshots.isEmpty(); }
    public int totalSnapshots() { return snapshots.size(); }
}