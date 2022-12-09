package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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
    private Label expErrorLabel;
    
    @FXML
    private DatePicker datePicker;
    
    private ExpenseEntry expEntry;
    
    private ArrayList<ExpenseEntry> expHistory;
    
    private ExpenseDate expDate; 
    
    private ArrayList<ExpenseDate> expDateList;
    
    private double currentExp = 0.0;
    
    private double currentBal = 0.0;
    
    
    @FXML
    void enterBudget(ActionEvent event) {  	    	
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
    	expDateList = new ArrayList<ExpenseDate>();
    	system.setText("Expense History created");
        System.out.println("date list created");
        
    }
    
    
    @FXML
    void addExpense(ActionEvent addExpEvent) {	    	
    	LocalDate date = datePicker.getValue();    	
    	int y = date.getYear();
    	int m = date.getMonthValue();
    	int d = date.getDayOfMonth();
    	expDate = new ExpenseDate();
    	//expDate.setExpDate(date)
    	expDate.setYear(y);
    	expDate.setMonth(m);
    	expDate.setDay(d);
    	//expDate = new ExpenseDate(date, y, m, d);
    	
    	System.out.println(expDate.dateToHistory());
    	
    	String t = expType.getValue();
    	String n = note.getText();
    	String a = expAmount.getText();   	   
    	expEntry = new ExpenseEntry(t, n, a);
    	
    	//Error Checking
    	expErrorLabel.setText("");
    	String expEntered = expAmount.getText();
    	Expense exp = new Expense(expEntered);	
    	
    	boolean add = exp.checkToAddExp(expEntered);
    	if(add == false) {
        	expErrorLabel.setText(exp.setValue(expEntered));
    	}
    	if(add == true) {
        	expAdded.setText("Expense added:\n" + expEntry.getEntry());	
        	expHistory.add(expEntry);
        	expDateList.add(expDate);
        	
        	for(int i = 0; i < expDateList.size(); i++) {
                System.out.println("date added " + expDateList.get(i).dateToHistory());
        	}
        	
        	//Update expense and balance
        	double expValue = Double.parseDouble(a);
        	currentExp = currentExp + expValue;
        	String updExp = Double.toString(currentExp);
        	expDisplay.setText(updExp);
        	
        	currentBal = currentBal - currentExp;
        	String updBal = Double.toString(currentBal);
        	balDisplay.setText(updBal);     		
    	}
    }
    
    
    @FXML
    void getExpHistory(ActionEvent expHistoryEvent) {
    	Scene mainScene = mainStage.getScene();
    	
    	VBox expHistoryBox = new VBox();
    	expHistoryBox.setPrefSize(350, 100);

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
    		
    		Collections.sort(expDateList, new SortByTime());
	
    		Label date = new Label(expDateList.get(i).dateToHistory());
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

}

