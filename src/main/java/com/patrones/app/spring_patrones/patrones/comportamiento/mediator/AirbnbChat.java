package com.patrones.app.spring_patrones.patrones.comportamiento.mediator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AirbnbChat implements MensajeMediator {
    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final List<Map<String, String>> historial = new ArrayList<>();


    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
    }
    @Override
    public void enviarMensaje(String mensaje, String remitenteId, String destinatarioId) {
        Usuario remitente = usuarios.get(remitenteId);
        Usuario destinatario = usuarios.get(destinatarioId);

        System.out.println("Remitente: " + remitente);
        System.out.println("Destinatario: " + destinatario);

        if (remitente == null || destinatario == null) return;

        destinatario.recibir(mensaje, remitente.getNombre());

        Map<String, String> registro = new HashMap<>();
        registro.put("de", remitente.getNombre());
        registro.put("para", destinatario.getNombre());
        registro.put("mensaje", mensaje);
        registro.put("tipo", remitente.getTipo());
        historial.add(registro);
    }
    public List<Map<String, String>> getHistorial(){return historial;}
    public Map <String, Usuario> getUsuarios(){return usuarios;}
}
