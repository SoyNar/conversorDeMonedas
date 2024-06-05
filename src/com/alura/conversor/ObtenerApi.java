package com.alura.conversor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ObtenerApi {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";
    public static String obtenerTasasDeCambio() {
        try {
            // Crear un cliente HTTP
            HttpClient cliente = HttpClient.newHttpClient();

            // Crear una solicitud HTTP GET
            HttpRequest solicitud = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de respuesta
            if (respuesta.statusCode() == HttpURLConnection.HTTP_OK) {
                return respuesta.body();
            } else {
                return "Error al obtener las tasas de cambio";
            }
        } catch (IOException | InterruptedException e) {
            return "Error al conectar con la API";
        }
    }
}
