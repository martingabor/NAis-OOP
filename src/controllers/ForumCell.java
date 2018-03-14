package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;
import other.Comment;

public final class ForumCell extends ListCell<Comment> {
	

	  public ForumCell(ListView<Comment> list) {
		super();        
	  }
	  
	    private final ForumCellController ccc = new ForumCellController();
	    private final Node view = ccc.getBox();

	    @Override
	    protected void updateItem(Comment item, boolean empty) {
	        super.updateItem(item, empty);
	        if (empty) {
	            setGraphic(null);
	        } else {
	            ccc.setInfo(item);
	            setGraphic(view);
	        }
	    }

	

}
