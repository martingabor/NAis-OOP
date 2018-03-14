package controllers;

import java.io.IOException;

import com.sun.glass.ui.View;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import other.Comment;

public class ForumCellController  {
	
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


		public ForumCellController() {
	    	 	FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ForumCell.fxml"));
	    	 	loader.setController(this);	
	    	 	
	    	try {
				loader.load();					
				
			} catch (IOException e) {
				throw new RuntimeException();
			}	
	    	
    	 	commentTextLabel.setWrapText(true);

	    	
	    }

	    public void setInfo(Comment item)
	    {
	        nicknameLabel.setText(item.getNickname());
	        timeLabel.setText(item.getDatetime());
	        titleLabel.setText(item.getTitle());
	        commentTextLabel.setText(item.getText());
	        
	    }

	    public SplitPane getBox()
	    {
	        return commentPane;
	    }
	    

}
