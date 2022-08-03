package fr.simplon.neptunians.Hotel_Neptune;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController extends BackToController {
	
	@FXML
	private TextField fieldFirstName;
	@FXML
	private TextField fieldName;
	@FXML
	private TextField fieldDay;
	@FXML
	private TextField fieldMonth;
	@FXML
	private TextField fieldYear;
	@FXML
	private TextField fieldEmail;
	@FXML
	private PasswordField fieldPass;
	@FXML
	private TextField fieldcomfPass;
	@FXML
	private Button btnSubmitCreateAccount;
	@FXML
	private Button btnReturnMainPage;
	
	@FXML
    private void btnReturnMainPage() throws IOException {
        App.setRoot("primary");
    }
	
	
	
}