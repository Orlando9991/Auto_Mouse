module com.rewdev.auto_mouse {
    requires javafx.controls;
    requires javafx.fxml;
    

    opens com.rewdev.auto_mouse to javafx.fxml;
    exports com.rewdev.auto_mouse;
}
