package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import other.Comment;
import users.*;

public class ForumController implements Initializable, ScreenSwitcher {
	@FXML
	private ListView<Comment> listView;
	@FXML
	private TextArea textInput;
	@FXML
	private TextField titleInput;
	@FXML
	private Button sendButton;
	@FXML
	private Button backButton;
	@FXML
	private Label timeLabel;
	
	private User activeUser;
	
	
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-hh HH:mm:ss");
	private ObservableList<Comment> listViewContent = FXCollections.observableArrayList();
	

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
        listView.setCellFactory(new Callback<ListView<Comment>, ListCell<Comment>>() {
            @Override
            public ListCell<Comment> call(final ListView<Comment> list) {
                return new ForumCell(list);
            }
        });
			
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e ->  {
		    
		    timeLabel.setText(LocalDateTime.now().format(dtf));
		}),
			new KeyFrame(Duration.seconds(1))
		);
		
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
		
		textInput.setWrapText(true);
	
		loadComments();
		Collections.reverse(listViewContent);


	    listView.setItems(listViewContent);
		

		

		sendButton.setOnAction(event -> {
			
			Collections.reverse(listViewContent);
			listViewContent.add(new Comment(activeUser.getNickname(), timeLabel.getText(), titleInput.getText(), textInput.getText()));
			Collections.reverse(listViewContent);
		
			addComment();
			
			textInput.clear();
			titleInput.clear();
		});
		
		backButton.setOnAction(event -> {
			switchToLoginScreen(backButton);
			
		});
		
	}
	
	private void addComment() {
		try {
			Connection connection;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NAis","postgres","admin");
			Statement stmt = connection.createStatement();
			
			stmt.executeUpdate("insert into comments (id_user, datetime, title, comment_text) values (" + activeUser.getUser_id() +",'" + timeLabel.getText() + "' , '" + titleInput.getText() + "' , '" + textInput.getText() + "');"); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void loadComments() {
		Comment comment;
		try {
			Connection connection;
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/NAis","postgres","admin");
			Statement stmt = connection.createStatement();
			ResultSet rset = stmt.executeQuery("select u.nickname, c.datetime, c.title, c.comment_text from comments c join users u on u.id=c.id_user");
			while(rset.next()) {
				comment = new Comment(rset.getString("nickname"),rset.getString("datetime"),rset.getString("title"),rset.getString("comment_text"));
				listViewContent.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void sendButtonAction() {
		sendButton.fire();
	}
	public void backButtonAction() {
		backButton.fire();
	}
	
	public void setActiveUser(int user_id, String nickname, String first_name, String last_name, int gender, String date_of_birth, String city, String address) {
		this.activeUser = new Student(user_id, nickname, first_name, last_name, gender, date_of_birth, city, address);
	}
	
	public void setActiveUser(User user) {
		this.activeUser = user;
	}

	public User getActiveUser() {
		return activeUser;
	}
	
	


}
