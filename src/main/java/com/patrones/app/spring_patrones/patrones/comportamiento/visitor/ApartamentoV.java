package com.patrones.app.spring_patrones.patrones.comportamiento.visitor;

    public class ApartamentoV extends ListingV {

        private final int habitaciones;
        private final int baños;

        public ApartamentoV(String titulo, double precioPorNoche, String ubicacion,
                            int habitaciones, int baños) {
            super(titulo, precioPorNoche, ubicacion);
            this.habitaciones = habitaciones;
            this.baños = baños;
        }

        @Override
        public String aceptar(ListingVisitor visitor) {
            return visitor.visitar(this); // le dice al visitor "soy un apartamento"
        }

        public int getHabitaciones() { return habitaciones; }
        public int getBaños() { return baños; }
    }