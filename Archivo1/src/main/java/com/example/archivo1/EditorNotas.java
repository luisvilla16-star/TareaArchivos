package com.example.archivo1;
    import java.io.*;

    public class EditorNotas {
        File nombreArchivo;

        public EditorNotas(String nombreArchivo) {

            this.nombreArchivo = new File(nombreArchivo);
        }

        public void guardar(String texto) {

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.nombreArchivo))) {
                writer.write(texto);
                System.out.println("Archivo guardado con éxito.");

            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }

        }

        public String cargar() {

            if (!this.nombreArchivo.exists()) {
                return "El archivo no existe todavía.";
            }

            String linea;
            String contenido = "";

            try (BufferedReader reader =
                         new BufferedReader(new FileReader(this.nombreArchivo))) {

                while ((linea = reader.readLine()) != null) {

                    contenido += linea + "\n";
                }

            } catch (IOException e) {

                return "Error al leer el archivo: " + e.getMessage();
            }

            return contenido;
        }
        public void agregar(String texto){
            try( BufferedWriter writer = new BufferedWriter(new FileWriter(this.nombreArchivo,true))){
                writer.newLine();
                writer.write(texto);

                System.out.println("Texto agregado con éxito.");
            } catch (IOException e) {
                System.out.println("Error al guardar el texto nuevo: " + e.getMessage());
            }
        }

        public void editar(String nuevoTexto){
            guardar(nuevoTexto);
            System.out.println("Contenido editado.");
        }

    }


