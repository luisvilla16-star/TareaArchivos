import Utileria.ManejoDeBits;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String ruta = "C:/Users/LUIS GABRIEL VILLA/Downloads/OAC Practica 8.pdf";
String ruta2 = "C:\\Users\\LUIS GABRIEL VILLA\\Pictures\\dibujo5.png";

        ManejoDeBits mb = new ManejoDeBits(ruta);
        ManejoDeBits mc = new ManejoDeBits(ruta2);

        // Leer los primeros 8 bytes
        ArrayList<Integer> bytes = mb.leer8bytes();
        ArrayList<Integer> bytes2 =  mc.leer8bytes();

        // Detectar formato
        String formato = mb.verificarFormato(bytes);
        String formato2 = mb.verificarFormato(bytes2);

        // Mostrar resultado
        System.out.println("Formato detectado: " + formato);
        System.out.println("Formato detectado: " + formato2);
    }
}