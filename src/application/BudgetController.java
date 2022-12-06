package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BudgetController {

	@FXML
	private Label bdgDisplay;
	
	@FXML
	private Label expDisplay;
	
	@FXML
	private Label balDisplay;
	
	@FXML
	private ChoiceBox<String> expType;
	
	@FXML
	private TextField budget;
	
	@FXML
	private TextField note;
	
	@FXML
	private TextField expAmount;
    
    @FXML
    void enterBudget(ActionEvent event) {
    	double currentBal = 0.0;
    	double money = Double.parseDouble(budget.getText());
    	currentBal = money;
    	bdgDisplay.setText(String.format("$%.2f", currentBal));
    	balDisplay.setText(String.format("$%.2f", currentBal));
    }
}
