package com.patrones.app.spring_patrones.patrones.creacionales.prototype;

public abstract class EstrategiaPreciosBase implements EstrategiaPrecios {
    protected String nombre;
    protected double porcentajeDescuento;
    protected double tarifaLimpieza;

    public EstrategiaPreciosBase(String nombre, double porcentajeDescuento, double tarifaLimpieza) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
        this.tarifaLimpieza = tarifaLimpieza;
    }

    public EstrategiaPreciosBase(EstrategiaPreciosBase otra) {
        this.nombre = otra.nombre;
        this.porcentajeDescuento = otra.porcentajeDescuento;
        this.tarifaLimpieza = otra.tarifaLimpieza;
    }

    @Override
    public double calcularPrecioFinal(double precioBase) {
        double precio = precioBase;
        precio -= precio * (porcentajeDescuento / 100);
        precio += tarifaLimpieza;
        return Math.round(precio * 100.0) / 100.0;
    }

    @Override
    public String getResumen() {
        return String.format(
            "Descuento: %.0f%% | Tarifa limpieza: €%.0f",
            porcentajeDescuento, tarifaLimpieza
        );
    }

    @Override public String getNombre()      { return nombre; }
    public double getDescuento()             { return porcentajeDescuento; }
    public double getTarifaLimpieza()        { return tarifaLimpieza; }

    public void setNombre(String nombre)             { this.nombre = nombre; }
    public void setDescuento(double d)               { this.porcentajeDescuento = d; }
    public void setTarifaLimpieza(double t)          { this.tarifaLimpieza = t; }
}