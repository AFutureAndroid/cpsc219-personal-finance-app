package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SummaryController {

	 Stage mainStage;
		
	 Scene mainScene;
	
	 Parent root;

	
    public void goToMain(ActionEvent goToSummaryEvent) throws FileNotFoundException, IOException {
		Parent root = FXMLLoader.load(getClass().getResource("HomeWindow.fxml"));
		mainStage = (Stage)((Node)goToSummaryEvent.getSource()).getScene().getWindow();
		mainScene = new Scene(root);
		mainStage.setScene(mainScene);
		mainStage.show();
    }

}
