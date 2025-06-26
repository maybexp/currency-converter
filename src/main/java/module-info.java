module com.example.currencyconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.currencyconverter to javafx.fxml;
    exports com.example.currencyconverter;
}