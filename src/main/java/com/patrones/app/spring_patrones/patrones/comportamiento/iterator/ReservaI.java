package com.patrones.app.spring_patrones.patrones.comportamiento.iterator;


public class ReservaI {

    private final String id;
    private final String huesped;
    private final String alojamiento;
    private final String estado; 
    private final String mes;
    private final double total;
    private final double calificacionHuesped;

    public ReservaI(String id, String huesped, String alojamiento,
                    String estado, String mes, double total, double calificacionHuesped) {
        this.id = id;
        this.huesped = huesped;
        this.alojamiento = alojamiento;
        this.estado = estado;
        this.mes = mes;
        this.total = total;
        this.calificacionHuesped = calificacionHuesped;
    }

    public String getId() { return id; }
    public String getHuesped() { return huesped; }
    public String getAlojamiento() { return alojamiento; }
    public String getEstado() { return estado; }
    public String getMes() { return mes; }
    public double getTotal() { return total; }
    public double getCalificacionHuesped() { return calificacionHuesped; }
}