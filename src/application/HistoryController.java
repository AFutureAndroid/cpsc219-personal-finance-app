package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HistoryController {
	
	Stage mainStage;
		
	Scene mainScene;
	
	Parent root;
	
	@FXML
    private Label dateCol;
	
	@FXML
    private Label typeCol;
	
	@FXML
    private Label amountCol;
	
	@FXML
    private Label noteCol;
	
    ArrayList<ExpenseEntry> expList;

	
	public void showAllEntries(ArrayList<ExpenseEntry> expList) {
		int i = 0;
    	int numOfEntries = expList.size();  	
    	while(i < numOfEntries) {        
    		
    		Collections.sort(expList, new SortByTime());
    		
    		dateCol.setText(expList.get(i).dateToHistory());
    		typeCol.setText(expList.get(i).typeToHistory());
    		amountCol.setText(expList.get(i).amountToHistory());
    		noteCol.setText(expList.get(i).noteToHistory());

    		
//    		Label date = new Label(expHistory.get(i).dateToHistory());
//    		Label type = new Label(expHistory.get(i).typeToHistory());
//    		Label amount = new Label(expHistory.get(i).amountToHistory());
//    		Label note = new Label(expHistory.get(i).noteToHistory());
   	
        	i++;
    	}
	}
	
	
    public void goToMain(ActionEvent goToSummaryEvent) throws FileNotFoundException, IOException {
		Parent root = FXMLLoader.load(getClass().getResource("HomeWindow.fxml"));
		mainStage = (Stage)((Node)goToSummaryEvent.getSource()).getScene().getWindow();
		mainScene = new Scene(root);
		mainStage.setScene(mainScene);
		mainStage.show();
    }

}
