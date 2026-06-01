package com.patrones.app.spring_patrones.patrones.estructurales.proxy;

import java.util.Set;

public class ServicioAlojamientoProxy implements ServicioAlojamiento{
    private final SerivicioAlojamientoReal servicioReal = new SerivicioAlojamientoReal();

    private final  Set<String> usuariosAutenticados = Set.of("token-admin", "token-huesped", 
    "token-anfitrion");

    private final Set<String> usuariosPrivilegiados = Set.of(
        "token-admin", "token-anfitrion"
    );

    private boolean estaAutenticado(String token){
        return usuariosAutenticados.contains(token);
    }
    private boolean esPrivilegiado(String token){
        return usuariosPrivilegiados.contains(token);
    }

    @Override
    public String verDetalle(String alojamientoId) {
        return servicioReal.verDetalle(alojamientoId);
    }

    @Override
    public String verPrecio(String alojamientoId) {
        return servicioReal.verPrecio(alojamientoId);
    }
    @Override
    public String verDatosAnfitrion(String alojamientoId) {
   
        return servicioReal.verDatosAnfitrion(alojamientoId);
    }
    public String acceder(String token, String recurso, String alojamientoId){
        String log = "[LOG] Token: " + token + " intentó acceder a: " + recurso;
        return switch(recurso) {
            case "detalle" ->{ 
                yield log + "\n" + verDetalle(alojamientoId);
            }
            case "precio" -> {
                if (!estaAutenticado(token)) {
                    yield "[PROXY BLOQUEÓ] Acceso denegado a precio — inicia sesión" + log;
                }
                yield log + "\n" + verPrecio(alojamientoId);
            }
            case "anfitrion" -> {
                if(!estaAutenticado(token)){
                    yield "[PROXY BLOQUEÓ] Acceso denegado — inicia sesión";
                }
                if(!esPrivilegiado(token)){
                    yield "[PROXY BLOQUEÓ] Acceso denegado a datos del anfitrión — sin permisos";
                }
                yield log + "\n"+ verDatosAnfitrion(alojamientoId);

            }
            default-> "Proxy desbloqueo recurso desconocido";
        };
    }
}
