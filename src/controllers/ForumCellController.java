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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import other.Comment;

public class ForumCellController {
	
	  @FXML
	    private HBox hBox;
	    @FXML
	    private Label label1;
	    @FXML
	    private Label label2;

	    public ForumCellController() {
	    	 	FXMLLoader loaderoo = new FXMLLoader(getClass().getResource("../gui/ForumCell.fxml"));
	    	 	loaderoo.setController(this);
	    	 	
	    	try {
				loaderoo.load();					
				
			} catch (IOException e) {
				throw new RuntimeException();
			}	   
	    	
	    }

	    public void setInfo(String string)
	    {
	        label1.setText(string);
	        label2.setText(string);
	    }

	    public HBox getBox()
	    {
	        return hBox;
	    }
	    

}
