package com.example.archivo2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HelloApplication extends Application {

    TableView<Dato> tabla;

    ObservableList<Dato> datos =
            FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {

        Button abrir = new Button("Cargar TXT");

        tabla = new TableView<>();

        // COLUMNA NOMBRE
        TableColumn<Dato, String> columnaTipo =
                new TableColumn<>("Dato");

        columnaTipo.setCellValueFactory(
                dato -> new SimpleStringProperty(
                        dato.getValue().getTipo()
                )
        );

        // COLUMNA VALOR
        TableColumn<Dato, String> columnaValor =
                new TableColumn<>("Valor");

        columnaValor.setCellValueFactory(
                dato -> new SimpleStringProperty(
                        dato.getValue().getValor()
                )
        );

        tabla.getColumns().add(columnaTipo);
        tabla.getColumns().add(columnaValor);

        tabla.setItems(datos);

        abrir.setOnAction(e -> {

            FileChooser chooser = new FileChooser();

            chooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(
                            "Archivos TXT",
                            "*.txt"
                    )
            );

            File archivo =
                    chooser.showOpenDialog(stage);

            if (archivo != null) {

                EstadisticasTexto estadisticas =
                        new EstadisticasTexto(
                                archivo.getAbsolutePath()
                        );

                String resultado =
                        estadisticas.estadisticas();

                datos.clear();

                String[] lineas =
                        resultado.split("\n");

                for (String linea : lineas) {

                    String[] partes =
                            linea.split(": ");

                    datos.add(
                            new Dato(
                                    partes[0],
                                    partes[1]
                            )
                    );
                }
            }
        });

        VBox root = new VBox(10);

        root.getChildren().addAll(
                abrir,
                tabla
        );

        Scene scene =
                new Scene(root, 400, 300);

        stage.setTitle("Estadísticas TXT");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}