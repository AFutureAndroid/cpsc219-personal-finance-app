package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BudgetController {
	private double initialInput;
	private double expenseInput;
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
    private Label expenseErrorLabel;

    @FXML
    void getExpHistory(ActionEvent event) {
    	System.out.println("button");
    	Scene expHistoryScene = new Scene(new Label("Expenese History"));
    	applicationStage.setScene(expHistoryScene);
    }
    
    @FXML
    void enterBudget(ActionEvent event) { // Sets the budget
    	budgetErrorLabel.setText("");

    	Calculator myBudget = new Calculator(0, 0);
    	budgetErrorLabel.setText(myBudget.setValue(budget.getText()));    	
    	
    	double budgetVal = myBudget.getCurrentBalance();    	
    	
    	bdgDisplay.setText(String.format("$%.2f", budgetVal));
    	balDisplay.setText(String.format("$%.2f", budgetVal));
    }
    
    @FXML
    void enterExpense(ActionEvent event) {
    	expenseInput = 0;
    }
    
    @FXML 
    void calculateCurrentBalance(ActionEvent event) {
    	expenseErrorLabel.setText("");
    	initialInput = 0;
    	//boolean noErrors = true;
    	
    	Calculator currentBal = new Calculator(0, 0);
    	Calculator currentExp = new Calculator(0, 0);
    	expenseErrorLabel.setText(currentExp.setValue(expAmount.getText()));
    	
    	budgetErrorLabel.setText(currentBal.setValue(budget.getText()));  
    	double updBal = currentBal.getCurrentBalance() + currentExp.getExpense();
    	double updExp = currentExp.getExpense();
    	balDisplay.setText(String.format("$%.2f", updBal));
    	expDisplay.setText(String.format("$%.2f", updExp));
    }
}

