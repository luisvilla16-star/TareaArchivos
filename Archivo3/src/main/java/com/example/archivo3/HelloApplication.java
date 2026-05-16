package com.example.archivo3;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HelloApplication extends Application {

    TableView<ObservableList<String>> tabla =
            new TableView<>();

    @Override
    public void start(Stage stage) {

        FileChooser chooser = new FileChooser();

        chooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Archivos CSV",
                        "*.csv"
                )
        );

        File archivo =
                chooser.showOpenDialog(stage);

        if (archivo != null) {

            // USAR TU CLASE
            VisualizadorCVS visualizador =
                    new VisualizadorCVS(
                            archivo.getAbsolutePath()
                    );

            cargarTabla(visualizador);
        }

        VBox root = new VBox(tabla);

        Scene scene =
                new Scene(root, 600, 400);

        stage.setTitle("Visualizador CSV");

        stage.setScene(scene);

        stage.show();
    }

    public void cargarTabla(
            VisualizadorCVS visualizador
    ) {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(
                                     visualizador.nombreArchivo
                             )
                     )) {

            String linea;

            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {

                String[] datos =
                        linea.split(",");

                // CREAR COLUMNAS
                if (primeraLinea) {

                    for (int i = 0; i < datos.length; i++) {

                        final int columna = i;

                        TableColumn<
                                ObservableList<String>,
                                String> tableColumn =
                                new TableColumn<>(datos[i]);

                        tableColumn.setCellValueFactory(
                                param ->
                                        new SimpleStringProperty(
                                                param.getValue()
                                                        .get(columna)
                                        )
                        );

                        tabla.getColumns()
                                .add(tableColumn);
                    }

                    primeraLinea = false;

                } else {

                    ObservableList<String> fila =
                            FXCollections.observableArrayList();

                    fila.addAll(datos);

                    tabla.getItems().add(fila);
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        launch();
    }
}