package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This is the controller class for the budgeting application.
 * Works with user inputs, and changes the scene when required.
 */
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
    private Label recExp;
    
    @FXML
    private Label bdgErrorLabel;
    
    @FXML
    private Label expErrorLabel;
    
    @FXML
    private Label avgExp;
    
    @FXML
    private Label maxExp;
    
    @FXML
    private Label minExp;
    
    @FXML
    private DatePicker expDate;
    
    private ExpenseEntry expEntry;
  
    private ArrayList<ExpenseEntry> expHistory;
    
    private double currentExp = 0.0;
    
    private double currentBal = 0.0;
    
    /**
     * Handles user input for budget value, sets error labels
     * and displays. Also initiates the expense history.
     * 
     * @param event User clicks the enter button to trigger event.
     */
    @FXML
    private void enterBudget(ActionEvent event) {  	    	
    	bdgErrorLabel.setText("");
    	
    	//Error Checking
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
    
    /**
     * Works with user input to add expenses and update displays.
     * New expense is added to the expense history.
     * 
     * @param addExpEvent User clicks the add expense button to trigger.
     */
    @FXML
    private void addExpense(ActionEvent addExpEvent) {
    	int year = expDate.getValue().getYear();
    	int month = expDate.getValue().getMonthValue();
    	int day = expDate.getValue().getDayOfMonth();
    	
    	LocalDate d = LocalDate.of(year, month, day);
    	String t = expType.getValue();
    	String n = note.getText();
    	String a = expAmount.getText();
    	
    	expEntry = new ExpenseEntry(d, t, n, a);    
    	
    	//Error Checking.
    	expErrorLabel.setText("");
    	String expEntered = expAmount.getText();
    	Expense exp = new Expense(expEntered);	
    	
    	boolean add = exp.checkToAddExp(expEntered);
    	if(add == false) {
        	expErrorLabel.setText(exp.setValue(expEntered));
    	}
    	if(add == true) { 
    		expHistory.add(expEntry);
    		recExp.setText(getRecExp(expHistory, recExp));	
        	
        	//Update expense and balance
        	double expValue = Double.parseDouble(a);
        	currentExp = currentExp + expValue;
        	String updExp = Double.toString(currentExp);
        	double newExp = Double.parseDouble(updExp);
        	expDisplay.setText(String.format("$%.2f", newExp));
        	
        	currentBal = currentBal - currentExp;
        	String updBal = Double.toString(currentBal);
        	double newBal = Double.parseDouble(updBal);
        	balDisplay.setText(String.format("$%.2f", newBal));     	  	
    	}
    	SummaryCalculation summary = new SummaryCalculation(expHistory);
    	double avg = summary.getAvgExpPerDay();
    	double max = summary.getMaxExp();
    	double min = summary.getMinExp();
    	
    	avgExp.setText(String.format("$%.2f", avg));
    	maxExp.setText(String.format("$%.2f", max));
    	minExp.setText(String.format("$%.2f", min));


    }

    /**
     * Displays the history in a new window. Also creates return button,
     * to return to the main scene.
     * 
     * @param expHistoryEvent User clicks expense history to trigger event.
     */
	@FXML
    void getExpHistory(ActionEvent expHistoryEvent) {
    	Scene mainScene = mainStage.getScene();
    	
    	VBox expHistoryBox = new VBox();
    	expHistoryBox.setPrefSize(350, 150);

    		Label expHistoryLabel = new Label("-------------------------Expense History-------------------------");
    		expHistoryBox.getChildren().add(expHistoryLabel);
    		
    		HBox titles = new HBox();
    			Label dateTitle = new Label("\t" + "Date" + "\t\t");
    			Label typeTitle = new Label("Type" + "\t\t\t");
    			Label amountTitle = new Label("Amount" + "\t\t");
    			Label noteTitle= new Label("Note" + "\t\t");  	
    		titles.getChildren().addAll(dateTitle, typeTitle, amountTitle, noteTitle);
    		expHistoryBox.getChildren().add(titles);
    		
    		Label separation1 = new Label("-------------------------------------------------------------------");
    		expHistoryBox.getChildren().add(separation1);
    		
    		HBox coloums = new HBox(); 
    			VBox dateCol = new VBox();
    			dateCol.setPrefSize(80, 100);
    			VBox typeCol = new VBox();
    			typeCol.setPrefSize(80, 100);
    			VBox amountCol = new VBox();
    			amountCol.setPrefSize(80, 100);
    			VBox noteCol = new VBox();
    			noteCol.setPrefSize(40, 100);
    		coloums.getChildren().addAll(dateCol, typeCol, amountCol, noteCol);
    		expHistoryBox.getChildren().add(coloums);	
    	
    		Label separation2 = new Label("-------------------------------------------------------------------");
    		expHistoryBox.getChildren().add(separation2);
    	
    	int i = 0;
    	int numOfEntries = expHistory.size(); 
    	
    	while(i < numOfEntries) {        
    		Collections.sort(expHistory, new SortByTime());
    		
    		Label date = new Label(expHistory.get(i).dateToHistory());
    		dateCol.getChildren().add(date);
    		Label type = new Label(expHistory.get(i).typeToHistory());
    		typeCol.getChildren().add(type);
    		Label amount = new Label(expHistory.get(i).amountToHistory());
    		amountCol.getChildren().add(amount);
    		Label note = new Label(expHistory.get(i).noteToHistory());
    		noteCol.getChildren().add(note);

        	i++;
    	}
    	
    	Button returnButton = new Button("Go Back");
    	returnButton.setOnAction(returnEvent -> mainStage.setScene(mainScene));     	
    	
    	expHistoryBox.getChildren().add(returnButton);
    	Scene expHistoryScene = new Scene(expHistoryBox);
    	mainStage.setScene(expHistoryScene);
    }
	
	@FXML
	public void updateSummary() {
		
		
	}
	
	
	public void recAscendOrder(ActionEvent ascend) {
		Collections.sort(expHistory, new SortByTime().reversed());
		recExp.setText(getRecExp(expHistory, recExp));	
	}
	
	public void recdescendOrder(ActionEvent descend) {
		Collections.sort(expHistory, new SortByTime());
		recExp.setText(getRecExp(expHistory, recExp));	
	}
	
    
    public void clearHistory(ActionEvent clearHistoryEvent) {
    	recExp.setText("");	
    	expHistory.clear();
    	
    }
    
    /**
     * Finds string with most recent expense in history.
     * 
     * @param expHistory ArrayList history of expenses.
     * @param recExp Label will be updated with most recent expense.
     * @return String that is the most recent expense.
     */
    private String getRecExp(ArrayList<ExpenseEntry> expHistory, Label recExp) {
    	int size = expHistory.size();
    	String content = "";
    	if(size == 1) {
    		content = expHistory.get(0).getEntry();
    		return content;
    	}
    	else if(size == 2) {
    		content = expHistory.get(0).getEntry() + "\n" +
    				  expHistory.get(1).getEntry();
    		return content;
    	}
    	else if(size == 3) {
    		content = expHistory.get(0).getEntry() + "\n" +
    				  expHistory.get(1).getEntry() + "\n" +
    				  expHistory.get(2).getEntry();
    		return content;
    	}
    	else {
    		content = expHistory.get(size-1).getEntry() + "\n" +
  				  	  expHistory.get(size-2).getEntry() + "\n" +
  				  	  expHistory.get(size-3).getEntry(); 
    	}
		return content;
	}
    
    
    
     
}

