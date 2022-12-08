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
    private Label expDisplay;

    @FXML
    private ChoiceBox<String> expType;

    @FXML
    private TextField budget;
    
    @FXML
    private Label system;
    
    @FXML
    private Label expAdded;
    
    @FXML
    private Label bdgErrorLabel;
    
    private ExpenseEntry expEntry;
    
    private ArrayList<ExpenseEntry> expHistory;
    
    private double currentExp = 0.0;
    
    private double currentBal = 0.0;
    
    
    @FXML
    void enterBudget(ActionEvent event) {
    	double money = Double.parseDouble(budget.getText());
    	currentBal = money;
    	bdgDisplay.setText(String.format("$%.2f", currentBal));
    	balDisplay.setText(String.format("$%.2f", currentBal));
    	
    	expHistory = new ArrayList<ExpenseEntry>();
    	system.setText("Expense History created");
        System.out.println("History created");
    }
    
    
//    @FXML
//    void createHistory(ActionEvent createHisotryEvent) {
//    	expHistory = new ArrayList<ExpenseEntry>();
//    	system.setText("Expense History created");
//        System.out.println("History created");
//    }
    
    
    @FXML
    void addExpense(ActionEvent addExpEvent) {
    	if(expHistory == null) {
    		system.setText("Please Create History first!");
    	}
    	
    	String t = expType.getValue();
    	String n = note.getText();
    	String a = expAmount.getText();
    	
    	expEntry = new ExpenseEntry(t, n, a);    	
    	expHistory.add(expEntry);
    	
    	expAdded.setText("Expense added: " + expEntry.toString());
    	
    	//Update expense and balance
    	double expValue = Double.parseDouble(a);
    	currentExp = currentExp + expValue;
    	String updExp = String.valueOf(currentExp);
    	expDisplay.setText(updExp);
    	
    	currentBal = currentBal - currentExp;
    	String updBal = String.valueOf(currentBal);
    	balDisplay.setText(updBal);

    	
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

}

