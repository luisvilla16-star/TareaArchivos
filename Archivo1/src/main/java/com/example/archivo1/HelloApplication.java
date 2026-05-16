package com.example.archivo1;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {


        TextArea areaTexto;

        EditorNotas editor;

        @Override
        public void start(Stage stage) {

            areaTexto = new TextArea();

            Button abrir = new Button("Abrir");
            Button guardar = new Button("Guardar");
            Button agregar = new Button("Agregar");
            Button editar = new Button("Editar");

            // ABRIR
            abrir.setOnAction(e -> {

                FileChooser chooser = new FileChooser();

                File archivo = chooser.showOpenDialog(stage);

                if (archivo != null) {

                    editor = new EditorNotas(archivo.getAbsolutePath());

                    editor.cargar();
                }
            });

            // GUARDAR
            guardar.setOnAction(e -> {

                FileChooser chooser = new FileChooser();

                File archivo = chooser.showSaveDialog(stage);

                if (archivo != null) {

                    editor = new EditorNotas(archivo.getAbsolutePath());

                    editor.guardar(areaTexto.getText());
                }
            });

            // AGREGAR
            agregar.setOnAction(e -> {

                if (editor != null) {
                    editor.agregar(areaTexto.getText());
                }

            });

            // EDITAR
            editar.setOnAction(e -> {

                if (editor != null) {
                    editor.editar(areaTexto.getText());
                }

            });

            VBox root = new VBox();

            root.getChildren().addAll(
                    abrir,
                    guardar,
                    agregar,
                    editar,
                    areaTexto
            );

            Scene scene = new Scene(root, 600, 400);

            stage.setTitle("Editor de Notas");

            stage.setScene(scene);

            stage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }