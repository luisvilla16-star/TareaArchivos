module com.example.archivo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.archivo2 to javafx.fxml;
    exports com.example.archivo2;
}