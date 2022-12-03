package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BudgetController {

    @FXML
    private TextField budgetTextfield;
    
    @FXML
    private Label currentBalance;

    @FXML
    void enterBudget(ActionEvent event) {
    	double currentBal = 0.0;
    	double budget = Double.parseDouble(budgetTextfield.getText());
    	currentBal = budget;
    	currentBalance.setText(String.format("$%.2f", currentBal));
    }
}
