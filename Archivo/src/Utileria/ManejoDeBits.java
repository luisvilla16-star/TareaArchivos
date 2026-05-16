package Utileria;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

    public class ManejoDeBits {
        File nombreArchivo;

        public ManejoDeBits(String nombreArchivo) {
            this.nombreArchivo = new File(nombreArchivo);
        }

        public void escribirByte(int c) {

        }

        public int leerByte() {
            int unByte = -1;
            FileInputStream in = null;

            try {
                in = new FileInputStream(nombreArchivo);
                if ((unByte = in.read()) != -1) {
                    System.out.println(unByte);
                }

                if ((unByte = in.read()) != -1) {
                    System.out.println(unByte);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (in != null) ;
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return unByte;
        }

        public ArrayList<Integer> leer8bytes() {
            int unByte = -1;
            int contador = 0;

            ArrayList<Integer> ochoByte = new ArrayList<>();
            FileInputStream in = null;

            try {
                in = new FileInputStream(nombreArchivo);
                while ((unByte = in.read()) != -1 && (contador < 8)) {
                    ochoByte.add(unByte);
                    contador++;
                }

                if ((unByte = in.read()) != -1) {
                    System.out.println(unByte);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (in != null) ;
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return ochoByte;
        }

        public String verificarFormato(ArrayList<Integer> ochoByte) {

                String formato = "";

                int valor = ochoByte.get(0);

                ArrayList<Integer> formatoPDF = new ArrayList<>();
                formatoPDF.add(Integer.parseInt("25", 16));

                ArrayList<Integer> formatoJPG = new ArrayList<>();
                formatoJPG.add(Integer.parseInt("FF", 16));

                ArrayList<Integer> formatoPNG = new ArrayList<>();
                formatoPNG.add(Integer.parseInt("89", 16));

                ArrayList<Integer> formatoZIP = new ArrayList<>();
                formatoZIP.add(Integer.parseInt("50", 16));

                ArrayList<Integer> formatoMP4 = new ArrayList<>();
                formatoMP4.add(Integer.parseInt("66", 16));

                ArrayList<Integer> formatoGIF = new ArrayList<>();
                formatoGIF.add(Integer.parseInt("47", 16));

                if (valor == formatoPDF.get(0)) {
                    formato = "PDF";
                }

                if (valor == formatoJPG.get(0)) {
                    formato = "JPG";
                }

                if (valor == formatoPNG.get(0)) {
                    formato = "PNG";
                }

                if (valor == formatoZIP.get(0)) {
                    formato = "ZIP";
                }

                if (valor == formatoMP4.get(0)) {
                    formato = "MP4";
                }

                if (valor == formatoGIF.get(0)) {
                    formato = "GIF";
                }


                return formato;
            }
        }


