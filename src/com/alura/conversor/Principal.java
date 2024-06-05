package com.alura.conversor;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMonedas conversor = new ConversorMonedas();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos dólares quieres convertir?");
        double cantidadEnDolares = scanner.nextDouble();

        System.out.println("¿A qué moneda quieres convertir?");
        System.out.println("1. Pesos argentinos (ARS)");
        System.out.println("2. Euros (EUR)");
        System.out.println("3. Yenes japoneses (JPY)");
        int opcion = scanner.nextInt();

        String monedaDestino;
        switch (opcion) {
            case 1:
                monedaDestino = "ARS";
                break;
            case 2:
                monedaDestino = "EUR";
                break;
            case 3:
                monedaDestino = "JPY";
                break;
            default:
                System.out.println("Opción inválida.");
                return;
        }

        double resultado = conversor.convertir(cantidadEnDolares, monedaDestino);
        System.out.println(cantidadEnDolares + " dólares son " + resultado + " " + conversor.tasasDeCambio.get(monedaDestino).getNombre() + ".");

    }

}
