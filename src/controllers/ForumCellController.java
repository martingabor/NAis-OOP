package controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import other.Comment;
import other.ForumCell;

public class ForumCellController {

	@FXML
	private SplitPane commentPane;
	@FXML
	private Label nicknameLabel;
	@FXML
	private Label timeLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label commentTextLabel;
	@FXML
	private Button deleteButton;

	public ForumCellController() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ForumCell.fxml"));
		loader.setController(this);

		try {
			loader.load();

		} catch (IOException e) {
			throw new RuntimeException();
		}

		commentTextLabel.setWrapText(true);
		
		deleteButton.setOnAction(event -> {
			
			
		});

	}
	


	public void setInfo(Comment item) {
		nicknameLabel.setText(item.getNickname());
		timeLabel.setText(item.getDatetime());
		titleLabel.setText(item.getTitle());
		commentTextLabel.setText(item.getText());

	}

	public SplitPane getBox() {
		return commentPane;
	}

}
