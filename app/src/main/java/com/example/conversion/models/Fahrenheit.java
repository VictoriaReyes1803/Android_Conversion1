package com.example.conversion.models;

public class Fahrenheit extends Grados{
    public Fahrenheit(Double valor){
        this.setValor(valor);
        this.setUnidad("c");
    }
    public static Fahrenheit parse(Celsius C) {
        Double c = (C.getValor() *1.8) +32;
        return new Fahrenheit(c);
    }

    public static Fahrenheit parse(Kelvin K) {
        Double c = ((K.getValor() - 273.15)*9/5+32);
        return new Fahrenheit(c);
    }

}
