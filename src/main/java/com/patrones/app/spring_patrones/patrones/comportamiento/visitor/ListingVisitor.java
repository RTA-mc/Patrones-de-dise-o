package com.patrones.app.spring_patrones.patrones.comportamiento.visitor;

public interface ListingVisitor {
    String visitar(ApartamentoV apartamento);
    String visitar(ExperienciaV experiencia);
}