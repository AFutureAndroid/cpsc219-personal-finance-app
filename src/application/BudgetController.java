package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    private ChoiceBox<String> expType;

    @FXML
    private Label expDisplay;

    @FXML
    private TextField budget;
    

    @FXML
    private Label budgetErrorLabel;
    
    @FXML
    private Label expenseErrorLabel;

    @FXML
    private Label system;
    
    @FXML
    private Label expAdded;
    
    private ExpenseEntry expEntry;
    
    private ArrayList<ExpenseEntry> expHistory;
    
    
    @FXML

    void enterBudget(ActionEvent event) {
    	Calculator myBudget = new Calculator(0, 0);
    	budgetErrorLabel.setText(myBudget.setValue(budget.getText()));    	
    	
    	double budgetVal = myBudget.getCurrentBalance();    	
    	
    	bdgDisplay.setText(String.format("$%.2f", budgetVal));
    	balDisplay.setText(String.format("$%.2f", budgetVal));
    }
    
    @FXML
    void createHistory(ActionEvent createHisotryEvent) {
    	expHistory = new ArrayList<ExpenseEntry>();
    	system.setText("Expense History created");
        System.out.println("History created");
    }
    
    
    @FXML
    void addExpense(ActionEvent addExpEvent) {
    	String t = expType.getValue();
    	String n = note.getText();
    	String a = expAmount.getText();
//    	System.out.println(t + "\t" + n + "\t" + a);
    	
    	expEntry = new ExpenseEntry(t, n, a);    	
    	expHistory.add(expEntry);
    	
    	expAdded.setText("Expense added: " + expEntry.toString());
    	
//    	for(int i = 0; i < expHistory.size(); i++)
//            System.out.println("entry added " + expHistory.get(i).toString());
    	
    }
    
    
    @FXML
    void getExpHistory(ActionEvent expHistoryEvent) {
    	Scene mainScene = applicationStage.getScene();
    	
    	VBox expHistoryBox = new VBox();
    	expHistoryBox.setPrefSize(300, 100);

    	Label expHistoryLabel = new Label("----------------Expense History----------------");
    	
    	HBox description = new HBox();
    	Label typeLabel = new Label("Expense Type" + "       ");
    	Label noteLabel = new Label("Note" + "       ");
    	Label amountLabel = new Label("Expense Amount" + "       ");
    	description.getChildren().addAll(typeLabel, noteLabel, amountLabel);
    	
    	Label separation = new Label("-------------------------------------------------");
    	expHistoryBox.getChildren().addAll(expHistoryLabel, description, separation);
    	
    	int i = 0;
    	int numOfEntries = expHistory.size();  	
    	while(i < numOfEntries) {
        	System.out.println(expHistory.get(i).toString());
        	Label l = new Label(expHistory.get(i).toString());
        	expHistoryBox.getChildren().add(l);
        	i++;
    	}
    	
    	Button returnButton = new Button("Go Back");
    	returnButton.setOnAction(returnEvent -> applicationStage.setScene(mainScene));
    	
    	
    	expHistoryBox.getChildren().add(returnButton);
    	Scene expHistoryScene = new Scene(expHistoryBox);
    	applicationStage.setScene(expHistoryScene);
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

