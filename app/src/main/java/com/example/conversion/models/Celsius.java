package com.example.conversion.models;

public class Celsius  extends  Grados

{
public Celsius(Double valor){
    this.setValor(valor);
    this.setUnidad("c");
}
    public static Celsius parse(Fahrenheit F) {
        Double c = (F.getValor() - 32) / 1.8;
        return new Celsius(c);
    }

    public static Celsius parse(Kelvin K) {
            Double c = K.getValor() - 273.15;
        return new Celsius(c);
    }

}
