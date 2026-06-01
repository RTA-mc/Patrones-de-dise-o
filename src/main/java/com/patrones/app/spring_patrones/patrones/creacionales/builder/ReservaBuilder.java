package com.patrones.app.spring_patrones.patrones.creacionales.builder;

 public class ReservaBuilder {

    public boolean seguroIncluido   = false;
    public boolean desayunoIncluido = false;
    public String cuponDescuento    = "Sin cupón";
    public int numeroHuespedes      = 1;
    public String notasEspeciales   = "Ninguna";

    public final String huespedNombre;
    public final String alojamiento;
    public final String fechaEntrada;
    public final String fechaSalida;

    public ReservaBuilder(String huespedNombre, String alojamiento,String fechaEntrada, String fechaSalida) {
        this.huespedNombre = huespedNombre;
        this.alojamiento   = alojamiento;
        this.fechaEntrada  = fechaEntrada;
        this.fechaSalida   = fechaSalida;
    } 
    public ReservaBuilder conSeguro() {
        this.seguroIncluido = true;
        return this;
    }

    public ReservaBuilder conDesayuno() {
        this.desayunoIncluido = true;
        return this;
    }

    public ReservaBuilder conCupon(String cupon) {
        this.cuponDescuento = cupon;
        return this;
    }

    public ReservaBuilder conHuespedes(int cantidad) {
        this.numeroHuespedes = cantidad;
        return this;
    }

    public ReservaBuilder conNotas(String notas) {
        this.notasEspeciales = notas;
        return this;
    }

    public Reserva build() {
        return new Reserva(this);
    }
}