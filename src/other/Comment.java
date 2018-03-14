package other;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;


public class Comment {
	@FXML
	private HBox hBox;
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	
	private String title;
	private String text;
	private String datetime;
	private String nickname;
	
	public Comment( String nickname, String datetime, String title, String text) {
		setNickname(nickname);
		setDatetime(datetime);
		setTitle(title);
		setText(text);
		
	
	}
	

	

	public String displayAsString() {
		return getNickname() + " " + getDatetime() + "\n" +getTitle() + "\n" +getText();
	}

	public String getNickname() {
		return nickname;
	}
	
	private void setNickname(String nickname) {
		this.nickname = nickname;
		
	}
	
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


}
