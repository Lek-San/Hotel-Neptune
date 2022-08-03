package fr.simplon.neptunians.Hotel_Neptune;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
	@FXML
	private TextField userId;
	@FXML
	private TextField userPassword;
	@FXML
	private Label testConnect;
	@FXML
	private Label findUser;
	@FXML
	private Label goToLoginPage;
	@FXML
	private Label goToSignupPage;
	@FXML
	private Label goToBackofficePage;

	public void demonstrationBouton(ActionEvent event) {
		System.out.println("hello");
		
	}
	
	public void goToLoginPage(ActionEvent event) throws IOException {
		App.setRoot("login");
	}
	public void goToSignupPage(ActionEvent event) throws IOException {
		App.setRoot("signup");
	}
	public void goToBackofficePage(ActionEvent event) throws IOException {
		App.setRoot("backoffice");
	}
	
	public void findUser(ActionEvent event) throws IOException {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		String connectQuery = "SELECT email FROM administrator";
		
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput = statement.executeQuery(connectQuery);
			
			while (queryOutput.next()) {
				if (queryOutput.getString("email") == "bouboule@simplon.fr") {
					System.out.println("youpi");
					System.out.println(queryOutput.getString("email"));
				};
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void connectButton(ActionEvent event) {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
				
		String connectQuery = "SELECT email FROM administrator";
		
		try {
			Statement statement = connectDB.createStatement();
			ResultSet queryOutput = statement.executeQuery(connectQuery);
			
			while (queryOutput.next()) {
				testConnect.setText(queryOutput.getString("email"));
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
