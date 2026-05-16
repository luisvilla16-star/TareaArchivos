module com.example.archivo3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.archivo3 to javafx.fxml;
    exports com.example.archivo3;
}