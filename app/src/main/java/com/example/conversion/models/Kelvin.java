package com.example.conversion.models;

public class Kelvin extends Grados{

    public Kelvin(Double valor){
        this.setValor(valor);
        this.setUnidad("c");
    }
    public static Kelvin parse(Fahrenheit F) {
        Double c = ((F.getValor() - 32)*5/9+273.15);
        return new Kelvin(c);
    }

    public static Kelvin parse(Celsius C) {
        Double c = C.getValor() + 273.15;
        return new Kelvin(c);
    }
}
