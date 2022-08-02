module fr.simplon.neptunians.Hotel_Neptune {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires javafx.base;

    opens fr.simplon.neptunians.Hotel_Neptune to javafx.fxml;
    exports fr.simplon.neptunians.Hotel_Neptune;
}