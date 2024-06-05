package com.alura.conversor;

public class Moneda {
    private String nombre;
    private double tasa;

    public Moneda (String nombre, double tasa){
        this.nombre = nombre;
        this.tasa = tasa;
    }
    public String getNombre(){
        return  nombre;
    }
    public double getTasa(){
        return  tasa;
    }

}

// constructor


