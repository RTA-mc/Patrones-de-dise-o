package com.patrones.app.spring_patrones.patrones.estructurales.facade;

    public class ServicioPago {

        public String procesarPago(String huesped, double monto) {
            return "Pago de $" + monto + " procesado para " + huesped + " vía Stripe";
        }

        public String verificarFraude(String huesped) {
            return "Verificación antifraude OK para " + huesped;
        }
    }