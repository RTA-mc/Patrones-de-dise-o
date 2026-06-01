package com.patrones.app.spring_patrones.patrones.estructurales.adapter;


public class AdaptadorJSONaXML {

    private final SistemaXML sistemaXML = new SistemaXML();

    public String adaptar(DatosJSON datosJSON) {

      
        String xml = "<bolsa>"
            + "<empresa>" + datosJSON.getEmpresa() + "</empresa>"
            + "<precio>"  + datosJSON.getPrecio()  + "</precio>"
            + "<volumen>" + datosJSON.getVolumen() + "</volumen>"
            + "</bolsa>";

        return sistemaXML.procesar(xml);
    }
}