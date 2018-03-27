package other;

import java.io.IOException;

import controllers.ForumCellController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;

public class ForumCell extends ListCell<Comment> {
	
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

	public ForumCell(ListView<Comment> list) {
		super();
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

	private final ForumCellController controller = new ForumCellController();
	private final Node view = controller.getBox();

	@Override
	protected void updateItem(Comment item, boolean empty) {
		super.updateItem(item, empty);
		if (empty) {
			setGraphic(null);
		} else {
			controller.setInfo(item);
			setGraphic(view);
		}
	}


}
