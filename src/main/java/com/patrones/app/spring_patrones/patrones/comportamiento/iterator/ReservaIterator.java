package com.patrones.app.spring_patrones.patrones.comportamiento.iterator;


public interface ReservaIterator {
    boolean hasNext();
    ReservaI next();
    void reset();
}