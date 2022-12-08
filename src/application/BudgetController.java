package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BudgetController {
	Stage mainStage;

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
    
    @FXML
    private DatePicker expDate;
    
    private ExpenseEntry expEntry;
    
    private ArrayList<ExpenseEntry> expHistory;
    
    private double currentExp = 0.0;
    
    private double currentBal = 0.0;
    
    
    @FXML
    void enterBudget(ActionEvent event) {
    	bdgErrorLabel.setText("");
    	
    	String bdgEntered = budget.getText();
    	Budget bdg = new Budget(bdgEntered);
    	bdgErrorLabel.setText(bdg.setValue(budget.getText()));
    	
    	double bdgValue = Double.parseDouble(bdgEntered);
    	currentBal = Double.parseDouble(bdgEntered);
    	bdgDisplay.setText(String.format("$%.1f", bdgValue));
    	balDisplay.setText(String.format("$%.1f", currentBal));
    	
    	expHistory = new ArrayList<ExpenseEntry>();
    	system.setText("Expense History created");
        System.out.println("History created");
    }
    
    
    @FXML
    void addExpense(ActionEvent addExpEvent) {
    	if(expHistory == null) {
    		system.setText("Please Create History first!");
    	}
    	
    	LocalDate d = expDate.getValue();
    	String t = expType.getValue();
    	String n = note.getText();
    	String a = expAmount.getText();
    	
    	expEntry = new ExpenseEntry(d, t, n, a);    	
    	expHistory.add(expEntry);
    	
    	expAdded.setText("Expense added: " + expEntry.toString());
    	
    	//Update expense and balance
    	double expValue = Double.parseDouble(a);
    	currentExp = currentExp + expValue;
    	String updExp = Double.toString(currentExp);
    	expDisplay.setText(updExp);
    	
    	currentBal = currentBal - currentExp;
    	String updBal = Double.toString(currentBal);
    	balDisplay.setText(updBal);
    	

    	
//    	for(int i = 0; i < expHistory.size(); i++)
//            System.out.println("entry added " + expHistory.get(i).toString());
    	
    }
    
    
    @FXML
    void getExpHistory(ActionEvent expHistoryEvent) {
    	Scene mainScene = mainStage.getScene();
    	
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
    	returnButton.setOnAction(returnEvent -> mainStage.setScene(mainScene));
    	
    	
    	expHistoryBox.getChildren().add(returnButton);
    	Scene expHistoryScene = new Scene(expHistoryBox);
    	mainStage.setScene(expHistoryScene);
    }

}

