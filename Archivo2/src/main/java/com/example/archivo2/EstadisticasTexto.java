package com.example.archivo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class EstadisticasTexto {
    File nombreArchivo;

    public EstadisticasTexto(String nombreArchivo) {
        this.nombreArchivo = new File(nombreArchivo);
    }

    public String estadisticas() {
        if (!this.nombreArchivo.exists()) {
            return "El archivo no existe todavía.";
        }
        int lineas=0;
        int palabra=0;
        int caracteres=0;
        String linea;

        try (BufferedReader reader = new BufferedReader(new FileReader(this.nombreArchivo))) {
            while ((linea = reader.readLine()) != null) {
                lineas++;
caracteres+= linea.length();

 String[] partes = linea.split("\\s+");

 palabra+=partes.length;

            }
        }catch (IOException e) {

                return "Error al leer el archivo: " + e.getMessage();
            }
        return "Líneas: " + lineas +
                "\nPalabras: " + palabra +
                "\nCaracteres: " + caracteres;

        }




}
