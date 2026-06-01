package com.patrones.app.spring_patrones.patrones.creacionales.abstractfaactory;

public interface  Pago {
    String procesar (double monto);
    String getMoneda();
    String getMetodo();
    
}
