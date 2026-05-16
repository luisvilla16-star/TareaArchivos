module com.example.archivo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.archivo1 to javafx.fxml;
    exports com.example.archivo1;
}