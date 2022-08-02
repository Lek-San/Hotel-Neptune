package fr.simplon.neptunians.Hotel_Neptune;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PrimaryController {
	@FXML
	private Label testConnect;

	public void connectButton(ActionEvent event) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
				
		String connectQuery = "SELECT nom FROM commune";
		
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput = statement.executeQuery(connectQuery);
			
			while (queryOutput.next()) {
				testConnect.setText(queryOutput.getString("nom"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
