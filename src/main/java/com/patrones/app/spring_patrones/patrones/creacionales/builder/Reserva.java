package com.patrones.app.spring_patrones.patrones.creacionales.builder;

public class Reserva {

    private final String huespedNombre;
    private final String alojamiento;
    private final String fechaEntrada;
    private final String fechaSalida;

    private final boolean seguroIncluido;
    private final boolean desayunoIncluido;
    private final String cuponDescuento;
    private final int numeroHuespedes;
    private final String notasEspeciales;

    public Reserva(ReservaBuilder builder) {
        this.huespedNombre    = builder.huespedNombre;
        this.alojamiento      = builder.alojamiento;
        this.fechaEntrada     = builder.fechaEntrada;
        this.fechaSalida      = builder.fechaSalida;
        this.seguroIncluido   = builder.seguroIncluido;
        this.desayunoIncluido = builder.desayunoIncluido;
        this.cuponDescuento   = builder.cuponDescuento;
        this.numeroHuespedes  = builder.numeroHuespedes;
        this.notasEspeciales  = builder.notasEspeciales;
    }

    public String getResumen() {
        return String.format(
            "Reserva de %s en %s del %s al %s — %d huésped(es)",
            huespedNombre, alojamiento, fechaEntrada, fechaSalida, numeroHuespedes
        );
    }

    public String getHuespedNombre()    { return huespedNombre; }
    public String getAlojamiento()      { return alojamiento; }
    public String getFechaEntrada()     { return fechaEntrada; }
    public String getFechaSalida()      { return fechaSalida; }
    public boolean isSeguroIncluido()   { return seguroIncluido; }
    public boolean isDesayunoIncluido() { return desayunoIncluido; }
    public String getCuponDescuento()   { return cuponDescuento; }
    public int getNumeroHuespedes()     { return numeroHuespedes; }
    public String getNotasEspeciales()  { return notasEspeciales; }
}