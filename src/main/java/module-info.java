module sio.gestionrestaurant {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    opens sio.gestionbulletin.Model;
    opens sio.gestionbulletin to javafx.fxml;
    exports sio.gestionbulletin;
}