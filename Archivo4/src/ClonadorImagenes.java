import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ClonadorImagenes {

    File imagen;

    public ClonadorImagenes(String imagen) {

        this.imagen = new File(imagen);
    }

    public void copiar() {

        try (
                FileInputStream in =
                        new FileInputStream(imagen);

                FileOutputStream out =
                        new FileOutputStream(
                                "C:\\Users\\LUIS GABRIEL VILLA\\Documents\\copia_entrada.jpg"
                        )
        ) {

            int c;

            while ((c = in.read()) != -1) {

                out.write(c);
            }

            System.out.println(
                    "Archivo de bytes copiado con éxito."
            );

        } catch (IOException e) {

            System.err.println(
                    "Error de E/S: " + e.getMessage()
            );
        }
    }
}

