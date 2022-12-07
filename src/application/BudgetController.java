package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BudgetController {
	double initialValue;
	Stage applicationStage;

    @FXML
    private TextField expAmount;

    @FXML
    private TextField note;

    @FXML
    private Label bdgDisplay;

    @FXML
    private Label balDisplay;

    @FXML
    private ChoiceBox<?> expType;

    @FXML
    private Label expDisplay;

    @FXML
    private TextField budget;
    
    @FXML
    private Label budgetErrorLabel;

    @FXML
    void getExpHistory(ActionEvent event) {
    	System.out.println("button");
    	Scene expHistoryScene = new Scene(new Label("Expenese History"));
    	applicationStage.setScene(expHistoryScene);
    }
    
    @FXML
    void enterBudget(ActionEvent event) { // Sets the budget
    	budgetErrorLabel.setText("");
    	double budgetValue = 0.0;
    	String budgetInput = budget.getText();
    	
    	Calculator myBudget = new Calculator(budgetValue, 0);
    	String errorMessage = myBudget.setValue(budgetInput);
    	budgetErrorLabel.setText(errorMessage);
    	double newBudget = myBudget.budgetValue;
    	
    	budgetValue = Double.parseDouble(budgetInput);
    	bdgDisplay.setText(String.format("$%.2f", newBudget));
    }
    @FXML 
    void getCurrentBalance(ActionEvent event) {
    	
    }
}

