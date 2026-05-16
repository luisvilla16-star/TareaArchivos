package com.example.archivo2;

public class Dato {

    private String tipo;
    private String valor;

    public Dato(String tipo, String valor) {

        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {

        return tipo;
    }

    public String getValor() {

        return valor;
    }
}