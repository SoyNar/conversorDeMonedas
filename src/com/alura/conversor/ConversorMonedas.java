package com.alura.conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.HashMap;

public class ConversorMonedas {
    private  Gson gson;
    public Map<String,Moneda> tasasDeCambio;

    public ConversorMonedas() {
        gson = new Gson();
        actualizarTasasDeCambio();
    }

    private void actualizarTasasDeCambio() {
        String respuestaApi = ObtenerApi.obtenerTasasDeCambio();
        JsonObject jsonObject = gson.fromJson(respuestaApi, JsonObject.class);
        JsonObject tasas = jsonObject.getAsJsonObject("rates");

        tasasDeCambio = new HashMap<>();
        tasasDeCambio.put("ARS", new Moneda("Pesos argentinos", tasas.getAsJsonPrimitive("ARS").getAsDouble()));
        tasasDeCambio.put("EUR", new Moneda("Euros", tasas.getAsJsonPrimitive("EUR").getAsDouble()));
        tasasDeCambio.put("JPY", new Moneda("Yenes japoneses", tasas.getAsJsonPrimitive("JPY").getAsDouble()));
    }

    public double convertir(double cantidad, String monedaDestino) {
        Moneda moneda = tasasDeCambio.get(monedaDestino);
        return cantidad * moneda.getTasa();
    }

}
