module com.dragon.pretty {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dragon.pretty to javafx.fxml;
    exports com.dragon.pretty;
}
