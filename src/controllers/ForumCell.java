package controllers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;

public final class ForumCell extends ListCell<String> {
	

	  public ForumCell(ListView<String> list) {
		super();
		Text text = new Text();
        text.wrappingWidthProperty().bind(list.widthProperty().subtract(15));
        text.textProperty().bind(itemProperty());

        setPrefWidth(0);
        setGraphic(text);
        
	}
	  
	    private final ForumCellController ccc = new ForumCellController();
	    private final Node view = ccc.getBox();

	    @Override
	    protected void updateItem(String item, boolean empty) {
	        super.updateItem(item, empty);
	        if (empty) {
	            setGraphic(null);
	        } else {
	            ccc.setInfo(item);
	            setGraphic(view);
	        }
	    }

	

}
