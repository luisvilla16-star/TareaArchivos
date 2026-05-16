package com.example.archivo3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class VisualizadorCVS{

    File nombreArchivo;

    public VisualizadorCVS(String nombreArchivo) {

        this.nombreArchivo = new File(nombreArchivo);
    }

    public void mostrarCSV() {

        if (!this.nombreArchivo.exists()) {

            System.out.println("El archivo no existe.");
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(this.nombreArchivo)
                     )) {

            String linea;

            while ((linea = reader.readLine()) != null) {


                String[] datos = linea.split(",");


                for (String dato : datos) {

                    System.out.print(dato + "\t");
                }

                System.out.println();
            }

        } catch (IOException e) {

            System.out.println(
                    "Error al leer el archivo: "
                            + e.getMessage()
            );
        }
    }
}