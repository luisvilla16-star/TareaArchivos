import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncriptadorXOR {

    File archivo;

    int clave = 123;

    public EncriptadorXOR(String archivo) {

        this.archivo = new File(archivo);
    }

    public void mascara() {

        try (
                FileInputStream in =
                        new FileInputStream(this.archivo);

                FileOutputStream out =
                        new FileOutputStream(
                                "copia_entrada.txt"
                        )
        ) {

            int c;

            while ((c = in.read()) != -1) {

                int byteEncriptado = c ^ clave;

                out.write(byteEncriptado);
            }

            System.out.println(
                    "Archivo encriptado correctamente."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }
}