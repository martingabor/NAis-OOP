package controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import users.*;

public class LoginController implements Initializable, ScreenSwitcher {
	@FXML
	private TextField nicknameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button loginButton;
	@FXML
	private Button registerButton;

	//private static User activeUser;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loginButton.setOnAction(event -> {
			new User((Stage)loginButton.getScene().getWindow(),nicknameField.getText(), passwordField.getText());

		});

		registerButton.setOnAction(event -> {
			switchToRegistrationScreen(registerButton);
		});

	}

	public void loginButtonAction() {
		loginButton.fire();
	}


//	public void setActiveUser(int user_id, String nickname, String first_name, String last_name, int gender,
//			String date_of_birth, String city, String address) {
//		LoginController.activeUser = new Student(user_id, nickname, first_name, last_name, gender, date_of_birth, city,
//				address);
//	}
//
//	public User getActiveUser() {
//		return activeUser;
//	}
//
//	public void setActiveUser(User activeUser) {
//		LoginController.activeUser = activeUser;
//	}

}
