module fr.simplon.neptunians.Hotel_Neptune {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.simplon.neptunians.Hotel_Neptune to javafx.fxml;
    exports fr.simplon.neptunians.Hotel_Neptune;
}